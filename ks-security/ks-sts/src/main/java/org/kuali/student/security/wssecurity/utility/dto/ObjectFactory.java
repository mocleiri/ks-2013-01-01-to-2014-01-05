
package org.kuali.student.security.wssecurity.utility.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.kuali.student.security.wssecurity.utility.dto package. 
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

    private final static QName _Expires_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Expires");
    private final static QName _Timestamp_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Timestamp");
    private final static QName _Created_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Created");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.kuali.student.security.wssecurity.utility.dto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TimestampType }
     * 
     */
    public TimestampType createTimestampType() {
        return new TimestampType();
    }

    /**
     * Create an instance of {@link AttributedDateTime }
     * 
     */
    public AttributedDateTime createAttributedDateTime() {
        return new AttributedDateTime();
    }

    /**
     * Create an instance of {@link AttributedURI }
     * 
     */
    public AttributedURI createAttributedURI() {
        return new AttributedURI();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributedDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", name = "Expires")
    public JAXBElement<AttributedDateTime> createExpires(AttributedDateTime value) {
        return new JAXBElement<AttributedDateTime>(_Expires_QNAME, AttributedDateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimestampType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", name = "Timestamp")
    public JAXBElement<TimestampType> createTimestamp(TimestampType value) {
        return new JAXBElement<TimestampType>(_Timestamp_QNAME, TimestampType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributedDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", name = "Created")
    public JAXBElement<AttributedDateTime> createCreated(AttributedDateTime value) {
        return new JAXBElement<AttributedDateTime>(_Created_QNAME, AttributedDateTime.class, null, value);
    }

}
