package com.sigmasys.bsinas.config;

import com.sigmasys.bsinas.model.Constants;
import com.sigmasys.bsinas.model.InitialParameter;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * KSA Config Service
 *
 * @author Michael Ivanov
 *         Date: 3/22/12
 *         Time: 4:58 PM
 */
@Service("configService")
@Transactional(readOnly = true)
public class ConfigServiceImpl implements ConfigService, InitializingBean {

    @Autowired
    private InitialParameterConfigurer parameterConfigurer;


    @Override
    public void afterPropertiesSet() {
        // Setting up locale if "locale" initial parameters exist
        String localeLang = getParameter(Constants.LOCALE_LANG_PARAM_NAME);
        if (localeLang != null && !localeLang.trim().isEmpty()) {
            String localeCountry = getParameter(Constants.LOCALE_COUNTRY_PARAM_NAME);
            Locale locale = (localeCountry != null && !localeCountry.trim().isEmpty()) ?
                    new Locale(localeLang, localeCountry) : new Locale(localeLang);
            Locale.setDefault(locale);
        }
    }

    @Override
    public String getParameter(String name) {
        return getParameters().get(name);
    }

    @Override
    public Map<String, String> getParameters() {
        return parameterConfigurer.getInitialParameters();
    }

    @Override
    @Transactional(readOnly = false)
    public Integer updateParameters(List<InitialParameter> params) {
        return parameterConfigurer.updateInitialParameters(params);
    }

    @Override
    @Transactional(readOnly = false)
    public Integer deleteParameters(Set<String> paramNames) {
        return parameterConfigurer.deleteInitialParameters(paramNames);
    }

    @Override
    public List<InitialParameter> getParameterList() {
        return parameterConfigurer.getInitialParameterList();
    }

    @Override
    public Map<String, String> refreshParameters() {
        parameterConfigurer.loadDatabaseParameters(true);
        return getParameters();
    }

    private Logger getLogger(String loggerName) {
        Logger logger = ("ROOT".equals(loggerName)) ? LogManager.getRootLogger() : LogManager.getLogger(loggerName);
        if (logger != null) {
            return logger;
        }
        throw new RuntimeException("Can not find logger '" + loggerName + "'");
    }

    @Override
    public void changeLoggingLevel(Map<String, String> loggers) {
        for (Map.Entry<String, String> entry : loggers.entrySet()) {
            String loggerName = entry.getKey();
            String loggerLevel = entry.getValue();
            getLogger(loggerName).setLevel(Level.toLevel(loggerLevel));
        }
    }

    @Override
    public Map<String, String> getLoggingLevel(String[] loggers) {
        Map<String, String> loggerMap = new HashMap<String, String>(loggers.length);
        for (String loggerName : loggers) {
            Logger logger = getLogger(loggerName);
            loggerMap.put(loggerName, logger.getLevel() != null ? logger.getLevel().toString() : null);
        }
        return loggerMap;
    }

}
