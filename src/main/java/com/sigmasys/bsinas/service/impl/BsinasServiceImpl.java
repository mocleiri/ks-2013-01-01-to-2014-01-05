package com.sigmasys.bsinas.service.impl;

import com.sigmasys.bsinas.config.ConfigService;
import com.sigmasys.bsinas.service.BsinasService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.annotation.PostConstruct;
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
import java.net.MalformedURLException;
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
@SuppressWarnings("unchecked")
public class BsinasServiceImpl implements BsinasService {

    private static final Log logger = LogFactory.getLog(BsinasServiceImpl.class);


    // Map of endpoint URLs and SOAP Dispatch instances
    private final Map<String, Dispatch<SOAPMessage>> dispatches =
            Collections.synchronizedMap(new HashMap<String, Dispatch<SOAPMessage>>());


    // Dynamic engine part
    private DocumentBuilder documentBuilder;
    private Transformer transformer;
    private MessageFactory messageFactory;


    @Autowired
    private ConfigService configService;

    @PostConstruct
    private void postConstruct() {

        try {

            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
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
     * @param inputXml NeedAnalysisInput's XML representation
     * @return NeedAnalysisOutput's XML representation
     */
    @Override
    public String runEngine(String inputXml) {
        return runDispatchEngine(inputXml);
    }

    private void attachNodesToSoapElement(Node node, SOAPElement soapElement, String rootNamespace) throws Exception {

        if (node.getNodeType() == Node.ELEMENT_NODE) {

            String elementName = node.getNodeName();

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

            NamedNodeMap attributes = node.getAttributes();
            if (attributes != null) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    Attr attribute = (Attr) attributes.item(i);
                    childSoapElement.setAttribute(attribute.getName(), attribute.getValue());
                }
            }

            Node child = node.getFirstChild();
            while (child != null) {
                attachNodesToSoapElement(child, childSoapElement, rootNamespace);
                child = child.getNextSibling();
            }

        } else if (node.getNodeType() == Node.TEXT_NODE) {
            soapElement.addTextNode(node.getNodeValue());
        }
    }

    private String getRootNamespace(String awardYear) {
        return "http://INAS.collegeboard.org/" + awardYear + "/";
    }

    private Dispatch<SOAPMessage> getDispatch(String awardYear) throws MalformedURLException {
        Dispatch<SOAPMessage> dispatch = dispatches.get(awardYear);
        if (dispatch == null) {
            String urlParamName = "bsinas.endpoint." + awardYear;
            String endpointUrl = configService.getParameter(urlParamName);
            if (endpointUrl == null || endpointUrl.trim().isEmpty()) {
                String errMsg = "Configuration parameter '" + urlParamName + "' is required";
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
            }
            String rootNamespace = getRootNamespace(awardYear);
            QName serviceName = new QName(rootNamespace, "NeedAnalysisXmlEngine");
            QName portName = new QName(rootNamespace, "basicHttp");
            javax.xml.ws.Service service = javax.xml.ws.Service.create(new URL(endpointUrl + "?wsdl"), serviceName);
            dispatch = service.createDispatch(portName, SOAPMessage.class, javax.xml.ws.Service.Mode.MESSAGE);
            Map<String, Object> context = dispatch.getRequestContext();
            context.put(BindingProvider.SOAPACTION_USE_PROPERTY, true);
            context.put(BindingProvider.SOAPACTION_URI_PROPERTY, rootNamespace + "INeedAnalysisXmlEngine/RunNeedAnalysis");
            dispatches.put(awardYear, dispatch);
        }
        return dispatch;
    }

    protected String runDispatchEngine(String inputXml) {

        try {

            // Converting the incoming XML into DOM
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(new StringReader(inputXml));

            Document document = documentBuilder.parse(inputSource);

            Element rootElement = document.getDocumentElement();

            // retrieving the award year from the XML root element's attribute
            String awardYear = rootElement.getAttribute("AwardYear");

            // Renaming the root node to "input" as required by BSINAS WSDL
            document.renameNode(rootElement, rootElement.getNamespaceURI(), "input");

            // Wrapping "input" sub-tree with "RunNeedAnalysis" node
            Element bodyElement = document.createElement("RunNeedAnalysis");
            bodyElement.appendChild(rootElement);

            // Creating the SOAP message
            SOAPMessage soapMessage = messageFactory.createMessage();

            SOAPBody soapBody = soapMessage.getSOAPPart().getEnvelope().getBody();

            // Attaching "RunNeedAnalysis" sub-tree to the SOAP body
            attachNodesToSoapElement(bodyElement, soapBody, getRootNamespace(awardYear));

            // Saving the changes made to the SOAP message
            soapMessage.saveChanges();

            // Getting the corresponding SOAP Dispatch instance for the current award year
            // and invoke the BSINAS service
            SOAPMessage response = getDispatch(awardYear).invoke(soapMessage);

            // Getting the response back as Document's Node instance
            org.w3c.dom.Node bodyNode = response.getSOAPBody().getFirstChild();

            // Converting the response to String
            return nodeToString(bodyNode);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }

    }


}
