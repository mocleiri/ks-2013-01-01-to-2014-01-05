package com.sigmasys.bsinas.gwt.server.impl;

import com.sigmasys.bsinas.annotation.UrlMapping;
import com.sigmasys.bsinas.config.ConfigService;
import com.sigmasys.bsinas.gwt.client.model.GwtError;
import com.sigmasys.bsinas.gwt.client.model.ReferenceData;
import com.sigmasys.bsinas.gwt.client.service.GwtConfigService;
import com.sigmasys.bsinas.gwt.server.AbstractRemoteService;
import com.sigmasys.bsinas.model.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;


/**
 * GwtConfigService implementation
 *
 * @author Michael Ivanov
 */
@UrlMapping(Constants.CONFIG_SERVICE_URL)
@Service("gwtConfigService")
@Transactional(readOnly = true)
public class GwtConfigServiceImpl extends AbstractRemoteService implements GwtConfigService {

    @Autowired
    private ConfigService configService;


    @Override
    public ReferenceData getReferenceData() throws GwtError {
        Locale locale = Locale.getDefault();
        return getReferenceData(locale.getLanguage(), locale.getCountry());
    }

    @Override
    public ReferenceData getReferenceData(String language, String country) throws GwtError {
        ReferenceData referenceData = new ReferenceData();
        referenceData.setInitialParameters(configService.getInitialParameters());
        return referenceData;
    }

}
