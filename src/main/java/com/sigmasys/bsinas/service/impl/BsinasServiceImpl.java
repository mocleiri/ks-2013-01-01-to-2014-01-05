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
import org.w3c.dom.*;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
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

    // Dynamic engine part
    private DocumentBuilder documentBuilder;
    private Transformer transformer;
    private MessageFactory messageFactory;


    @Autowired
    private ConfigService configService;

    private org.collegeboard.inas._2012.NeedAnalysisXmlEngine engine2012;
    private org.collegeboard.inas._2013.NeedAnalysisXmlEngine engine2013;


    @PostConstruct
    private void postConstruct() {

        try {

            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);

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

    protected String nodeToString(org.w3c.dom.Node node) {
        try {
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(node), new StreamResult(writer));
            return writer.toString();
        } catch (TransformerException te) {
            logger.error(te.getMessage(), te);
            throw new RuntimeException(te.getMessage(), te);
        }
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
        /*try {

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
        }*/

        return runDispatchEngine(inputXml);

    }

    private void attachNodesToSoapElement(Element element, SOAPElement soapElement, String rootNamespace) throws Exception {

        String elementName = element.getTagName();

        boolean isRunNeedAnalysis = "RunNeedAnalysis".equalsIgnoreCase(elementName);
        boolean isInput = "input".equalsIgnoreCase(elementName);

        final SOAPElement childSoapElement;

        if (isRunNeedAnalysis || isInput) {

            childSoapElement = soapElement.addChildElement(elementName, "ns3", rootNamespace);

            if (isRunNeedAnalysis) {
                childSoapElement.addNamespaceDeclaration("", rootNamespace + "Output/");
                childSoapElement.addNamespaceDeclaration("ns2", rootNamespace + "Input/");
                childSoapElement.addNamespaceDeclaration("ns4", rootNamespace + "faults/");
                childSoapElement.addNamespaceDeclaration("ns5", "http://schemas.microsoft.com/2003/10/Serialization/");
            }

        } else {
            childSoapElement = soapElement.addChildElement(elementName, "ns2", rootNamespace + "Input/");
        }

        NamedNodeMap attributes = element.getAttributes();
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                Attr attribute = (Attr) attributes.item(i);
                childSoapElement.setAttribute(attribute.getName(), attribute.getValue());
            }
        }

        Node child = element.getFirstChild();
        while (child != null) {
            if (child instanceof Element) {
                attachNodesToSoapElement((Element) child, childSoapElement, rootNamespace);
            }
            child = child.getNextSibling();
        }
    }

    public String runDispatchEngine(String inputXml) {

        try {

            // Converting the incoming XML into DOM
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(new StringReader(inputXml));

            Document document = documentBuilder.parse(inputSource);

            Element rootElement = document.getDocumentElement();

            logger.info("Root Element:\n" + nodeToString(rootElement));

            String awardYear = rootElement.getAttribute("AwardYear");

            String urlParamName = "bsinas.endpoint." + awardYear;

            String endpointUrl = configService.getInitialParameter(urlParamName);
            if (endpointUrl == null || endpointUrl.trim().isEmpty()) {
                String errMsg = "Configuration parameter '" + urlParamName + "' is required";
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
            }

            final String rootNamespace = "http://INAS.collegeboard.org/" + awardYear + "/";

            document.renameNode(rootElement, rootElement.getNamespaceURI(), "input");

            Element bodyElement = document.createElement("RunNeedAnalysis");

            bodyElement.appendChild(rootElement);

            logger.info("Body Document:\n" + nodeToString(bodyElement));

            QName serviceName = new QName(rootNamespace, "NeedAnalysisXmlEngine");
            QName portName = new QName(rootNamespace, "basicHttp");

            /** Create a service and add at least one port to it. **/
            javax.xml.ws.Service service = javax.xml.ws.Service.create(new URL(endpointUrl + "?wsdl"), serviceName);

            /** Create a Dispatch instance from a service.**/
            Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, javax.xml.ws.Service.Mode.MESSAGE);

            Map<String, Object> context = dispatch.getRequestContext();

            context.put(BindingProvider.SOAPACTION_USE_PROPERTY, true);
            context.put(BindingProvider.SOAPACTION_URI_PROPERTY, rootNamespace + "INeedAnalysisXmlEngine/RunNeedAnalysis");

            // Create a message.
            SOAPMessage soapMessage = messageFactory.createMessage();

            // Construct the message payload.
            SOAPBody soapBody = soapMessage.getSOAPPart().getEnvelope().getBody();

            attachNodesToSoapElement(bodyElement, soapBody, rootNamespace);

            soapMessage.saveChanges();

            logger.info("SOAP request:\n" + nodeToString(soapMessage.getSOAPPart()));

            /** Invoke the service endpoint. **/
            SOAPMessage response = dispatch.invoke(soapMessage);

            org.w3c.dom.Node bodyNode = response.getSOAPBody().getFirstChild();

            return nodeToString(bodyNode);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }

    }


}
