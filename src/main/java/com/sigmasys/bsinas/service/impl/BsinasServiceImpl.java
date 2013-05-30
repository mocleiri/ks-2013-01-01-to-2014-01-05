package com.sigmasys.bsinas.service.impl;

import com.sigmasys.bsinas.config.ConfigService;
import com.sigmasys.bsinas.model.Constants;
import com.sigmasys.bsinas.service.BsinasService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The default implementation of BSINAS service.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("bsinasService")
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class BsinasServiceImpl extends GenericPersistenceService implements BsinasService {

    private static final Log logger = LogFactory.getLog(BsinasServiceImpl.class);

    private static final QName BSINAS_QNAME_2012 =
            new QName("http://INAS.collegeboard.org/2012/", org.collegeboard.inas._2012.NeedAnalysisXmlEngine.class.getSimpleName());

    private static final QName BSINAS_QNAME_2013 =
            new QName("http://INAS.collegeboard.org/2013/", org.collegeboard.inas._2013.NeedAnalysisXmlEngine.class.getSimpleName());


    private final Map<Class, JAXBContext> jaxbContexts = Collections.synchronizedMap(new HashMap<Class, JAXBContext>());


    @Autowired
    private ConfigService configService;

    private org.collegeboard.inas._2012.NeedAnalysisXmlEngine engine2012;
    private org.collegeboard.inas._2013.NeedAnalysisXmlEngine engine2013;


    @PostConstruct
    private void postConstruct() {
        try {

            // Configuring 2012 engine
            String wsdlUrl = configService.getInitialParameter(Constants.BSINAS_2012_WSDL_URL_PARAM_NAME);
            if (StringUtils.isBlank(wsdlUrl)) {
                String errMsg = "Initial parameter '" + Constants.BSINAS_2012_WSDL_URL_PARAM_NAME + "' must be set";
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
            }
            engine2012 = new org.collegeboard.inas._2012.NeedAnalysisXmlEngine(new URL(wsdlUrl), BSINAS_QNAME_2012);

            // Configuring 2013 engine
            wsdlUrl = configService.getInitialParameter(Constants.BSINAS_2013_WSDL_URL_PARAM_NAME);
            if (StringUtils.isBlank(wsdlUrl)) {
                String errMsg = "Initial parameter '" + Constants.BSINAS_2013_WSDL_URL_PARAM_NAME + "' must be set";
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
            }
            engine2013 = new org.collegeboard.inas._2013.NeedAnalysisXmlEngine(new URL(wsdlUrl), BSINAS_QNAME_2013);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private JAXBContext getJaxbContext(Class<?> type) throws JAXBException {
        JAXBContext jaxbContext = jaxbContexts.get(type);
        if (jaxbContext == null) {
            jaxbContext = JAXBContext.newInstance(type);
            jaxbContexts.put(type, jaxbContext);
        }
        return jaxbContext;
    }

    /**
     * Parses the incoming XML specified by StringReader and converts it into a Java object using JAXB.
     *
     * @param xml String representation of XML
     * @return NeedAnalysisInput instance
     */
    protected <T> T fromXml(String xml, Class<T> type) throws JAXBException {
        Unmarshaller unmarshaller = getJaxbContext(type).createUnmarshaller();
        return (T) unmarshaller.unmarshal(new StringReader(xml));
    }

    /**
     * Takes an object instance and serializes it to XML.
     *
     * @param object a Java bean instance to be serialized to XML
     * @return String representation of XML
     */
    protected <T> String toXml(T object) throws JAXBException {
        StringWriter writer = new StringWriter();
        Marshaller marshaller = getJaxbContext(object.getClass()).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, writer);
        return writer.toString();
    }

    /**
     * Runs NeedAnalysisXmlEngine and returns the result.
     *
     * @param inputXml  NeedAnalysisInput's XML representation
     * @param awardYear Award Year
     * @return NeedAnalysisOutput's XML representation
     */
    @Override
    public String runEngine(String inputXml, int awardYear) {
        try {

            switch (awardYear) {
                case 2012:
                    return toXml(engine2012.getBasicHttp().runNeedAnalysis(
                            fromXml(inputXml, org.collegeboard.inas._2012.input.NeedAnalysisInput.class)));
                case 2013:
                    return toXml(engine2013.getBasicHttp().runNeedAnalysis(
                            fromXml(inputXml, org.collegeboard.inas._2013.input.NeedAnalysisInput.class)));
                default:
                    throw new IllegalStateException("Award year " + awardYear + " is not supported");
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }

    }


}
