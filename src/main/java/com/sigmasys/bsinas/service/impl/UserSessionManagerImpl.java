package com.sigmasys.bsinas.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.sigmasys.bsinas.service.UserSessionManager;

/**
 * UserSessionManagerImpl. A default implementation of UserSessionManager interface.
 *
 * @author Michael Ivanov
 */
@Service("userSessionManager")
public class UserSessionManagerImpl implements UserSessionManager {

    private static final Log logger = LogFactory.getLog(UserSessionManagerImpl.class);

    private static final String USER_ID = "userId";

    /**
     * Creates a new HTTP session
     *
     * @param request  the HTTP request
     * @param response the HTTP response
     * @param userId   the User ID
     * @return a new HTTP Session
     */
    @Transactional
    public HttpSession createSession(HttpServletRequest request, HttpServletResponse response, String userId) {
        HttpSession session = request.getSession(true);
        // Storing user ID in the session
        session.setAttribute(USER_ID, userId);
        logger.info("Creating session for user Id: " + userId);
        return session;
    }

    /**
     * Destroys the current HTTP session
     *
     * @param request the HTTP request
     */
    public void destroySession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            // Invalidating HTTP session
            session.invalidate();
        }
    }

    /**
     * Checks if the HTTP session is valid.
     *
     * @param request  the HTTP request
     * @param response the HTTP response
     * @return true if the session is valid.
     */
    public boolean isSessionValid(HttpServletRequest request,
                                  HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute(USER_ID) != null;
    }

    /**
     * Returns the user ID
     *
     * @param request HttpServletRequest
     * @return the user ID
     */
    public String getUserId(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (String) session.getAttribute(USER_ID);
        }
        throw new IllegalStateException("HTTP session is null");
    }

}
