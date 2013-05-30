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

    public String getInitialParameter(String name);

    public Map<String, String> getInitialParameters();

    public Integer updateInitialParameters(List<InitialParameter> params);

    public Integer deleteInitialParameters(Set<String> paramNames);

    public List<InitialParameter> getInitialParameterList();

    public Map<String, String> refreshInitialParameters();

    public void changeLoggingLevel(Map<String, String> loggers);

    public Map<String, String> getLoggingLevel(String[] loggers);

}
