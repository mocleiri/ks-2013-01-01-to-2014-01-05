package com.sigmasys.bsinas.service;

/**
 * The main BSINAS service that parses the incoming XML, using JAX WS sends the SOAP request and gets the response
 * containing the calculated
 */
public interface BsinasService {

    /**
     * Runs NeedAnalysisXmlEngine and returns the result.
     *
     * @param inputXml NeedAnalysisInput's XML representation
     * @return NeedAnalysisOutput's XML representation
     */
    String runEngine(String inputXml);

}
