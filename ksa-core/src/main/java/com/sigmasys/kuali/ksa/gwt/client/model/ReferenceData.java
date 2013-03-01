package com.sigmasys.kuali.ksa.gwt.client.model;

import java.io.Serializable;
import java.util.Map;

/**
 * ReferenceData
 *
 * @author Michael Ivanov
 */
@SuppressWarnings("serial")
public class ReferenceData implements Serializable {

    private Map<String, String> initialParameters;
    private Map<String, String> localizedParameters;


    public Map<String, String> getInitialParameters() {
        return initialParameters;
    }

    public void setInitialParameters(Map<String, String> initialParameters) {
        this.initialParameters = initialParameters;
    }

    public String getInitialParameter(String name) {
        return ( initialParameters != null ) ? initialParameters.get(name) : null;
    }

    public Map<String, String> getLocalizedParameters() {
        return localizedParameters;
    }

    public void setLocalizedParameters(Map<String, String> localizedParameters) {
        this.localizedParameters = localizedParameters;
    }

    public String getLocalizedParameter(String name) {
           return ( localizedParameters != null ) ? localizedParameters.get(name) : null;
    }
}