package com.sigmasys.bsinas.gwt.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.sigmasys.bsinas.gwt.client.model.GwtError;
import com.sigmasys.bsinas.gwt.client.model.ReferenceData;
import org.collegeboard.inas._2012.input.NeedAnalysisInput;
import org.collegeboard.inas._2012.output.NeedAnalysisOutput;

/**
 * GwtBsinasService
 *
 * @author Michael Ivanov
 */
public interface GwtBsinasService extends RemoteService {

    /**
     * Runs NeedAnalysisXmlEngine and returns the result.
     *
     * @param inputXml XML request
     * @param year Award year
     * @return XML response as java.util.String
     */
    String runEngine(String inputXml, int year) throws GwtError;

}
