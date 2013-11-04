package org.kuali.student.security.trust.service;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.2.8
 * Wed Jun 09 11:16:39 EDT 2010
 * Generated source version: 2.2.8
 * 
 */
 
@WebService(targetNamespace = "http://schemas.xmlsoap.org/ws/2005/02/trust/wsdl", name = "WSSecurityRequestor")
@XmlSeeAlso({org.kuali.student.security.wssecurity.secext.dto.ObjectFactory.class,org.kuali.student.security.trust.dto.ObjectFactory.class,org.kuali.student.security.wssecurity.utility.dto.ObjectFactory.class,org.kuali.student.security.addressing.dto.ObjectFactory.class,org.kuali.student.security.policy.dto.ObjectFactory.class,org.kuali.student.security.xmldsig.dto.ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface WSSecurityRequestor {

    @Oneway
    @WebMethod(operationName = "SecurityTokenResponse")
    public void securityTokenResponse(
        @WebParam(partName = "response", name = "RequestSecurityTokenResponse", targetNamespace = "http://schemas.xmlsoap.org/ws/2005/02/trust")
        org.kuali.student.security.trust.dto.RequestSecurityTokenResponseType response
    );

    @WebResult(name = "RequestSecurityTokenResponseCollection", targetNamespace = "http://schemas.xmlsoap.org/ws/2005/02/trust", partName = "responseCollection")
    @WebMethod(operationName = "Challenge2")
    public org.kuali.student.security.trust.dto.RequestSecurityTokenResponseCollectionType challenge2(
        @WebParam(partName = "response", name = "RequestSecurityTokenResponse", targetNamespace = "http://schemas.xmlsoap.org/ws/2005/02/trust")
        org.kuali.student.security.trust.dto.RequestSecurityTokenResponseType response
    );

    @Oneway
    @WebMethod(operationName = "SecurityTokenResponse2")
    public void securityTokenResponse2(
        @WebParam(partName = "responseCollection", name = "RequestSecurityTokenResponseCollection", targetNamespace = "http://schemas.xmlsoap.org/ws/2005/02/trust")
        org.kuali.student.security.trust.dto.RequestSecurityTokenResponseCollectionType responseCollection
    );

    @WebMethod(operationName = "Challenge")
    public void challenge(
        @WebParam(partName = "response", mode = WebParam.Mode.INOUT, name = "RequestSecurityTokenResponse", targetNamespace = "http://schemas.xmlsoap.org/ws/2005/02/trust")
        javax.xml.ws.Holder<org.kuali.student.security.trust.dto.RequestSecurityTokenResponseType> response
    );
}