package com.sigmasys.bsinas.gwt.server.impl;

import com.sigmasys.bsinas.annotation.UrlMapping;
import com.sigmasys.bsinas.gwt.client.model.GwtError;
import com.sigmasys.bsinas.gwt.client.service.GwtBsinasService;
import com.sigmasys.bsinas.gwt.server.AbstractRemoteService;
import com.sigmasys.bsinas.model.Constants;
import com.sigmasys.bsinas.service.BsinasService;
import com.sigmasys.bsinas.util.ErrorUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * GwtBsinasService implementation
 *
 * @author Michael Ivanov
 */
@UrlMapping(Constants.BSINAS_SERVICE_URL)
@Service("gwtBsinasService")
@Transactional(readOnly = true)
public class GwtBsinasServiceImpl extends AbstractRemoteService implements GwtBsinasService {

    private static final Log logger = LogFactory.getLog(GwtBsinasServiceImpl.class);

    @Autowired
    private BsinasService bsinasService;

    @Override
    public String runEngine(String inputXml, int year) throws GwtError {
        try {
            return bsinasService.runEngine(inputXml, year);
        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
            throw new GwtError(ErrorUtils.getMessage(t));
        }

    }
}
