
package org.collegeboard.inas.faults;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.collegeboard.inas.faults package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InvalidXmlSchemaFault_QNAME = new QName("http://INAS.collegeboard.org/faults/", "InvalidXmlSchemaFault");
    private final static QName _ServerFault_QNAME = new QName("http://INAS.collegeboard.org/faults/", "ServerFault");
    private final static QName _UnsupportedYearFault_QNAME = new QName("http://INAS.collegeboard.org/faults/", "UnsupportedYearFault");
    private final static QName _UnsupportedYearFaultBatchId_QNAME = new QName("http://INAS.collegeboard.org/faults/", "BatchId");
    private final static QName _UnsupportedYearFaultMessage_QNAME = new QName("http://INAS.collegeboard.org/faults/", "Message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.collegeboard.inas.faults
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UnsupportedYearFault }
     * 
     */
    public UnsupportedYearFault createUnsupportedYearFault() {
        return new UnsupportedYearFault();
    }

    /**
     * Create an instance of {@link ServerFault }
     * 
     */
    public ServerFault createServerFault() {
        return new ServerFault();
    }

    /**
     * Create an instance of {@link InvalidXmlSchemaFault }
     * 
     */
    public InvalidXmlSchemaFault createInvalidXmlSchemaFault() {
        return new InvalidXmlSchemaFault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidXmlSchemaFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/faults/", name = "InvalidXmlSchemaFault")
    public JAXBElement<InvalidXmlSchemaFault> createInvalidXmlSchemaFault(InvalidXmlSchemaFault value) {
        return new JAXBElement<InvalidXmlSchemaFault>(_InvalidXmlSchemaFault_QNAME, InvalidXmlSchemaFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServerFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/faults/", name = "ServerFault")
    public JAXBElement<ServerFault> createServerFault(ServerFault value) {
        return new JAXBElement<ServerFault>(_ServerFault_QNAME, ServerFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnsupportedYearFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/faults/", name = "UnsupportedYearFault")
    public JAXBElement<UnsupportedYearFault> createUnsupportedYearFault(UnsupportedYearFault value) {
        return new JAXBElement<UnsupportedYearFault>(_UnsupportedYearFault_QNAME, UnsupportedYearFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/faults/", name = "BatchId", scope = UnsupportedYearFault.class)
    public JAXBElement<String> createUnsupportedYearFaultBatchId(String value) {
        return new JAXBElement<String>(_UnsupportedYearFaultBatchId_QNAME, String.class, UnsupportedYearFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/faults/", name = "Message", scope = UnsupportedYearFault.class)
    public JAXBElement<String> createUnsupportedYearFaultMessage(String value) {
        return new JAXBElement<String>(_UnsupportedYearFaultMessage_QNAME, String.class, UnsupportedYearFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/faults/", name = "BatchId", scope = ServerFault.class)
    public JAXBElement<String> createServerFaultBatchId(String value) {
        return new JAXBElement<String>(_UnsupportedYearFaultBatchId_QNAME, String.class, ServerFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/faults/", name = "Message", scope = ServerFault.class)
    public JAXBElement<String> createServerFaultMessage(String value) {
        return new JAXBElement<String>(_UnsupportedYearFaultMessage_QNAME, String.class, ServerFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/faults/", name = "BatchId", scope = InvalidXmlSchemaFault.class)
    public JAXBElement<String> createInvalidXmlSchemaFaultBatchId(String value) {
        return new JAXBElement<String>(_UnsupportedYearFaultBatchId_QNAME, String.class, InvalidXmlSchemaFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/faults/", name = "Message", scope = InvalidXmlSchemaFault.class)
    public JAXBElement<String> createInvalidXmlSchemaFaultMessage(String value) {
        return new JAXBElement<String>(_UnsupportedYearFaultMessage_QNAME, String.class, InvalidXmlSchemaFault.class, value);
    }

}
