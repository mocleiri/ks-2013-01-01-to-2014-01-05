package com.sigmasys.bsinas.config;

import com.sigmasys.bsinas.model.InitialParameter;

import java.util.*;

/**
 * KSA Config Service
 *
 * @author Michael Ivanov
 *         Date: 3/22/12
 *         Time: 4:58 PM
 */
public interface ConfigService {

    public String getParameter(String name);

    public Map<String, String> getParameters();

    public Integer updateParameters(List<InitialParameter> params);

    public Integer deleteParameters(Set<String> paramNames);

    public List<InitialParameter> getParameterList();

    public Map<String, String> refreshParameters();

    public void changeLoggingLevel(Map<String, String> loggers);

    public Map<String, String> getLoggingLevel(String[] loggers);

}
