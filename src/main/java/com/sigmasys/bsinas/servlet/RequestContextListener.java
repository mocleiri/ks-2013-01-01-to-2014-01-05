package com.sigmasys.bsinas.servlet;

import com.sigmasys.bsinas.util.RequestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * RequestContextListener
 * User: IvanovM
 * Date: May 27, 2010
 * Time: 8:52:13 PM
 */
public class RequestContextListener implements ServletRequestListener {

    private final static Log logger = LogFactory.getLog(RequestContextListener.class);

    public void requestDestroyed(ServletRequestEvent event) {
        logger.debug("requestDestroyed is called");
        RequestUtils.setThreadRequest(null);
    }

    public void requestInitialized(ServletRequestEvent event) {
        logger.debug("requestInitialized is called");
        RequestUtils.setThreadRequest((HttpServletRequest) event.getServletRequest());
    }
}
