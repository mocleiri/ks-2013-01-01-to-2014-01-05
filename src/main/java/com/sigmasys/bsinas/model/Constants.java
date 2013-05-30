package com.sigmasys.bsinas.model;

/**
 * BSINAS commonly used constants.
 *
 * @author Michael Ivanov
 */
public interface Constants {

    // Persistence units
    String PROSAM_PERSISTENCE_UNIT = "prosam";

    String LOCALE_LANG_PARAM_NAME = "bsinas.locale.lang";
    String LOCALE_COUNTRY_PARAM_NAME = "bsinas.locale.country";

    // BSINAS parameter names
    String BSINAS_2012_WSDL_URL_PARAM_NAME = "bsinas.2012.wsdl.url";
    String BSINAS_2013_WSDL_URL_PARAM_NAME = "bsinas.2013.wsdl.url";
    String LOGGING_ENABLED_PARAM_NAME = "bsinas.logging.enabled";

    // ---------------------------------------------------------------
    // DATE FORMATS
    // ---------------------------------------------------------------
    String DATE_FORMAT_US = "MM/dd/yyyy"; // should actually be locale-based

    String TIMESTAMP_FORMAT = "MM/dd/yyyy HH:mm:ss.SSS";
    String TIMESTAMP_FORMAT_NO_MS = "MM/dd/yyyy HH:mm:ss";

    String TIME_FORMAT = "HH:mm:ss.SSS";
    String TIME_FORMAT_NO_MS = "HH:mm:ss";
    String TIME_FORMAT_MINUTES = "HH:mm";

    // URL mapping constants
    String CONFIG_SERVICE_URL = "config.service";
    String BSINAS_SERVICE_URL = "bsinas.service";

}
