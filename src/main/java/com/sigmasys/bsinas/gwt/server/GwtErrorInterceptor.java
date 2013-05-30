package com.sigmasys.bsinas.gwt.server;

import com.sigmasys.bsinas.gwt.client.model.GwtError;
import com.sigmasys.bsinas.util.ErrorUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.lang.reflect.Method;


@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GwtErrorInterceptor implements MethodInterceptor {

    private static final Log logger = LogFactory.getLog(GwtErrorInterceptor.class);

    private Object targetObject;

    public GwtErrorInterceptor() {
    }

    public GwtErrorInterceptor(Object targetObject) {
        this.targetObject = targetObject;
    }

    public void setTargetObject(Object target) {
        this.targetObject = target;
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method targetMethod = invocation.getMethod();
        for (Method method : targetObject.getClass().getMethods()) {
            if (methodsMatch(targetMethod, method)) {
                try {
                    return invocation.proceed();
                } catch (Throwable t) {
                    logger.error("Intercepted exception = " + t.toString());
                    // Marking the current transaction for rollback only
                    try {
                        TransactionStatus transactionStatus = TransactionAspectSupport.currentTransactionStatus();
                        if (!transactionStatus.isCompleted()) {
                            transactionStatus.setRollbackOnly();
                            logger.error("Transaction is set to rollback only");
                        }
                    } catch (Throwable ex) {
                        logger.warn("Cannot set transaction to rollback: " + ex.toString(), ex);
                    }
                    logger.info("Error occured while invoking method '" + method.getName() + "'", t);
                    throw getGwtError(t);
                }
            }
        }
        return invocation.proceed();
    }

    private boolean methodsMatch(Method method1, Method method2) {
        if (!method1.getName().equals(method2.getName())) {
            return false;
        }
        Class<?>[] paramTypes1 = method1.getParameterTypes();
        Class<?>[] paramTypes2 = method2.getParameterTypes();
        if (paramTypes1.length != paramTypes2.length) {
            return false;
        }
        for (int i = 0; i < paramTypes1.length; i++) {
            if (!paramTypes1[i].getName().equals(paramTypes2[i].getName())) {
                return false;
            }
        }
        return true;
    }

    public static GwtError getGwtError(Throwable t) {
        // If the exception is already GwtError - we don't have to do anything, but just throw it.
        return (t instanceof GwtError) ? (GwtError) t : new GwtError(ErrorUtils.getMessage(t), false);
    }

}


