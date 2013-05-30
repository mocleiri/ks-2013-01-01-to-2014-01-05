package com.sigmasys.bsinas.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sigmasys.bsinas.util.ContextUtils;
import com.sigmasys.bsinas.util.RequestUtils;

/**
 * Base class for all service tests.
 * It provides access to Spring application context, major services and HTTP mock-ups.
 *
 * @author IvanovM
 */
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public abstract class AbstractServiceTest implements BeanFactoryAware {

    public static final String TEST_USER_ID = "admin";

    protected final Log logger = LogFactory.getLog(getClass());

    public AbstractServiceTest() {

        // Setting up the test HTTP environment

        MockServletContext context = new MockServletContext();

        MockHttpServletRequest request = new MockHttpServletRequest(context);
        request.setRemoteUser(TEST_USER_ID);
        request.setSession(new MockHttpSession());

        RequestUtils.setServletContext(new MockServletContext());

        RequestUtils.setThreadRequest(request);
        RequestUtils.setThreadResponse(new MockHttpServletResponse());
    }

    protected void init(BeanFactory beanFactory) {
        ContextUtils.initContext(beanFactory);
        UserSessionManager sessionManager = ContextUtils.getBean("userSessionManager");
        sessionManager.createSession(RequestUtils.getThreadRequest(), RequestUtils.getThreadResponse(), TEST_USER_ID);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory)  {
          init(beanFactory);
    }
}
