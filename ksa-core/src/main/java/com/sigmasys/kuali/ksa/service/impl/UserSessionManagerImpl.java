package com.sigmasys.kuali.ksa.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sigmasys.kuali.ksa.service.security.AccessControlService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.sigmasys.kuali.ksa.service.UserSessionManager;

import java.util.Set;

/**
 * UserSessionManagerImpl. A default implementation of UserSessionManager interface.
 *
 * @author Michael Ivanov
 */
@Service("userSessionManager")
public class UserSessionManagerImpl implements UserSessionManager {

    private static final Log logger = LogFactory.getLog(UserSessionManagerImpl.class);

    private static final String USER_ID = "userId";
    private static final String USER_PERMISSIONS = "userPermissions";


    @Autowired
    private AccessControlService acService;

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
        // Storing user permissions in the session
        Set<String> permissions = acService.getUserPermissions(userId);
        if (CollectionUtils.isNotEmpty(permissions)) {
            session.setAttribute(USER_PERMISSIONS, permissions);
        }
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
     * Returns the user ID for the given HttpServletRequest.
     *
     * @param request HttpServletRequest instance
     * @return the user ID
     */
    public String getUserId(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (String) session.getAttribute(USER_ID);
        }
        throw new IllegalStateException("HTTP session is null");
    }

    /**
     * Returns a set of user permissions for the given HttpServletRequest.
     *
     * @param request HttpServletRequest instance
     * @return a set of user permission names.
     */
    @SuppressWarnings("unchecked")
    public Set<String> getUserPermissions(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (Set<String>) session.getAttribute(USER_PERMISSIONS);
        }
        throw new IllegalStateException("HTTP session is null");
    }

}
