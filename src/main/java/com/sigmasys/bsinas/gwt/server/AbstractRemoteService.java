package com.sigmasys.bsinas.gwt.server;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sigmasys.bsinas.annotation.ProxyEntityAnnotationResolver;
import com.sigmasys.bsinas.util.HibernateUtils;
import org.aopalliance.aop.Advice;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.Servlet;
import java.lang.reflect.InvocationTargetException;


/**
 * Base class that MUST be used for all Spring-managed services that are exposed as
 * GWT servlets to the client
 *
 * @author Michael Ivanov
 */
@SuppressWarnings("serial")
public abstract class AbstractRemoteService extends RemoteServiceServlet implements BeanFactoryAware {

    private static final Log logger = LogFactory.getLog(AbstractRemoteService.class);

    @Autowired
    private ProxyEntityAnnotationResolver proxyEntitiesResolver;

    @Autowired
    private GwtErrorInterceptor errorInterceptor;

    private Servlet aopProxy;

    private final ProxyFactory proxyFactory;


    public AbstractRemoteService() {
        proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(this);
    }


    @PostConstruct
    private void postConstruct() {
        // Setting up the error interceptor
        errorInterceptor.setTargetObject(this);
        addAdvice(errorInterceptor);
    }


    /**
     * Override to pass the proxy instead of this to dynamic method invocation
     */
    public String processCall(String payload) throws SerializationException {

        RPCRequest rpcRequest = RPC.decodeRequest(payload, getClass(), this);

        try {

            boolean useProxy = proxyEntitiesResolver.resolve(this, rpcRequest.getMethod());

            if (useProxy) {
                Object returnValue = rpcRequest.getMethod().invoke(getInstance(), rpcRequest.getParameters());
                // Making a copy with HibernateBeanReplicator
                returnValue = HibernateUtils.detach(returnValue);
                return RPC.encodeResponseForSuccess(rpcRequest.getMethod(), returnValue,
                        rpcRequest.getSerializationPolicy());
            }

            return RPC.invokeAndEncodeResponse(getInstance(), rpcRequest.getMethod(),
                    rpcRequest.getParameters(), rpcRequest.getSerializationPolicy());

        } catch (InvocationTargetException ex) {
            logger.error("InvocationTargetException occured. Processing proxied call to " + this.getClass() + " failed", ex);
            return RPCCopy.encodeResponseForFailure(rpcRequest.getMethod(),
                    GwtErrorInterceptor.getGwtError(ex.getCause()),
                    rpcRequest.getSerializationPolicy());
        } catch (IncompatibleRemoteServiceException ex) {
            logger.error("IncompatibleRemoteServiceException occured. Processing proxied call to " + this.getClass() + " failed", ex);
            return RPCCopy.encodeResponseForFailure(null, GwtErrorInterceptor.getGwtError(ex),
                    rpcRequest.getSerializationPolicy());
        } catch (Throwable ex) {
            logger.error("Processing non-proxied call to " + this.getClass() + " failed", ex);
            return RPC.encodeResponseForFailure(rpcRequest.getMethod(), GwtErrorInterceptor.getGwtError(ex),
                    rpcRequest.getSerializationPolicy());
        }
    }

    // For Spring AOP to work on method invocation we have to pass in the proxy instead of this

    private Servlet getInstance() {
        return (aopProxy != null) ? aopProxy : (Servlet) proxyFactory.getProxy();
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        Service serviceAnnotation = this.getClass().getAnnotation(Service.class);
        if (serviceAnnotation != null) {
            String beanName = serviceAnnotation.value();
            if (beanName == null || beanName.equals("")) {
                beanName = this.getClass().getSimpleName();
            }
            try {
                aopProxy = (Servlet) beanFactory.getBean(beanName);
            } catch (Exception e) {
                logger.error("Cannot find the bean specified by '" + beanName + "'", e);
                throw new RuntimeException("Cannot find the bean specified by '" + beanName + "'", e);
            }
        }
    }

    /**
     * Adds AOP advice to the current instance.
     *
     * @param advice Advice instance
     */
    protected void addAdvice(final Advice advice) {
        final Advised advised;
        if (aopProxy != null && aopProxy instanceof Advised) {
            logger.info("Setting interceptor " + advice + " to AOP proxy = " + aopProxy);
            advised = (Advised) aopProxy;
        } else {
            logger.info("Setting interceptor " + advice + " to proxy factory = " + proxyFactory);
            advised = proxyFactory;
        }
        advised.addAdvice(advice);
    }

}