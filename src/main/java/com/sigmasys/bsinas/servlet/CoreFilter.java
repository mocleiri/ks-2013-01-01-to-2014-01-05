package com.sigmasys.bsinas.servlet;

import com.sigmasys.bsinas.config.ConfigService;
import com.sigmasys.bsinas.service.UserSessionManager;
import com.sigmasys.bsinas.util.ContextUtils;
import com.sigmasys.bsinas.util.RequestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * The Core Filter
 *
 * @author Michael Ivanov
 */
// TODO: Provide authentication
public class CoreFilter implements Filter {

    private static final Log logger = LogFactory.getLog(CoreFilter.class);

    public static final String TRUSTED_URLS_PARAM_NAME = "trustedUrls";

    // Used for trusted URLs
    private static final String DEFAULT_USER_ID = "admin";

    private static final String DEFAULT_LOGIN_PATH = "/WEB-INF/jsp/login.jsp";

    private final Set<String> trustedUrls = new HashSet<String>();

    private final Object lock = new Object();

    private boolean isInitialized;

    private String loginPath;

    @Override
    public void init(FilterConfig config) throws ServletException {
        loginPath = config.getInitParameter("loginPath");
        if (loginPath == null) {
            loginPath = DEFAULT_LOGIN_PATH;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
    }

    private void initTrustedUrls() {
        ConfigService configService = ContextUtils.getBean(ConfigService.class);
        String trustedUrls = configService.getParameter(TRUSTED_URLS_PARAM_NAME);
        if (trustedUrls != null && !trustedUrls.isEmpty()) {
            String[] patterns = trustedUrls.split(",");
            for (String pattern : patterns) {
                pattern = pattern.trim();
                if (!pattern.isEmpty()) {
                    this.trustedUrls.add(pattern.toLowerCase());
                }
            }
        }
    }

    /**
     * Checks whether the URL is trusted so the webapp can proceed with request handling
     * without user authentication.
     *
     * @param request HttpServletRequest
     * @return true if trusted URL
     */
    private boolean isTrustedUrl(HttpServletRequest request) {
        String url = request.getRequestURI().toLowerCase();
        for (String trustedUrl : trustedUrls) {
            if (url.contains(trustedUrl)) {
                return true;
            }
        }
        return false;
    }

    private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        try {

            // Expose thread local response to the entire application
            RequestUtils.setThreadResponse(response);

            final UserSessionManager sessionManager = ContextUtils.getBean(UserSessionManager.class);

            // Initializing services if necessary
            synchronized (lock) {
                if (!isInitialized) {
                    initTrustedUrls();
                    isInitialized = true;
                }
            }

            if (!isTrustedUrl(request) && !sessionManager.isSessionValid(request, response)) {

                request.setAttribute("showPasswordField", true);

                String queryString = request.getQueryString();

                final String redirectUrl = request.getRequestURI() + (queryString != null ? "?" + queryString : "");
                request.setAttribute("redirectUrl", redirectUrl);

                //final String userId = request.getParameter("bsinas_userId");
                //final String password = request.getParameter("bsinas_password");

                //if (userId != null) {

                    // If the request has redirectUrl parameter ->
                    // redirect to the location specified by redirectUrl
                    String targetUrl = request.getParameter("redirectUrl");
                    if (targetUrl != null && !targetUrl.trim().isEmpty()) {
                        response.sendRedirect(targetUrl);
                    }

                  sessionManager.createSession(request, response, DEFAULT_USER_ID);

                /*} else {
                    invalidateSession(request, response, true);
                    return;
                }*/

            } /*else {
                // No session has been established and this is not a login form submission,
                // so forward to login page
                request.getRequestDispatcher(loginPath).forward(request, response);
                return;
            }*/


            logger.info("USER-REQUEST-INFO: user = '" + sessionManager.getUserId(request) +
                    "' requested URI = '" + request.getRequestURI() + "'");

            chain.doFilter(request, response);

        } catch (Throwable t) {
            logger.error("Error occurred while serving HTTP request: " + t.getMessage(), t);
        } finally {
            RequestUtils.setThreadResponse(null);
        }
    }

    /**
     * Handles and invalid login attempt.
     *
     * @param request  the incoming request
     * @param response the outgoing response
     * @throws ServletException if unable to handle the invalid login
     * @throws IOException      if unable to handle the invalid login
     */
    private void invalidateSession(HttpServletRequest request, HttpServletResponse response, boolean invalidLogin) throws ServletException, IOException {
        final UserSessionManager sessionManager = ContextUtils.getBean(UserSessionManager.class);
        if (sessionManager != null) {
            sessionManager.destroySession(request);
        }
        request.setAttribute("invalidLogin", invalidLogin);
        request.getRequestDispatcher(loginPath).forward(request, response);
    }

    @Override
    public void destroy() {
        loginPath = null;
        trustedUrls.clear();
    }
}
