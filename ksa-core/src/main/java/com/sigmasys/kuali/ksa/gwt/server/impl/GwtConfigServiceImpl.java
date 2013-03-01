package com.sigmasys.kuali.ksa.gwt.server.impl;

import com.sigmasys.kuali.ksa.annotation.UrlMapping;
import com.sigmasys.kuali.ksa.config.ConfigService;
import com.sigmasys.kuali.ksa.gwt.client.model.GwtError;
import com.sigmasys.kuali.ksa.gwt.client.model.ReferenceData;
import com.sigmasys.kuali.ksa.gwt.client.service.GwtConfigService;
import com.sigmasys.kuali.ksa.gwt.server.AbstractRemoteService;
import com.sigmasys.kuali.ksa.model.Constants;
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
        referenceData.setInitialParameters(configService.getParameterMap());
        referenceData.setLocalizedParameters(configService.getLocalizedParameters(new Locale(language, country)));
        return referenceData;
    }

}
