package com.sigmasys.bsinas.util;

import org.springframework.beans.factory.BeanFactory;

/**
 * ContextUtils
 *
 * @author Michael Ivanov
 */
@SuppressWarnings("unchecked")
public class ContextUtils {

    private static BeanFactory applicationContext;

    private ContextUtils() {
    }

    public static BeanFactory initContext(BeanFactory context) {
        if (context != null) {
            applicationContext = context;
            return applicationContext;
        }
        throw new IllegalArgumentException("Application context cannot be null");
    }

    public static BeanFactory getBeanFactory() {
        if (applicationContext == null) {
            throw new IllegalArgumentException("Application context cannot be null");
        }
        return applicationContext;
    }

    public static <T> T getBean(String name) {
        if (applicationContext == null) {
            throw new IllegalStateException("Application context is not initialized. Call one of init() methods prior to calling getBean()");
        }
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> beanInterface) {
        if (applicationContext == null) {
            throw new IllegalStateException("Application context is not initialized. Call one of init() methods prior to calling getBean()");
        }
        return applicationContext.getBean(beanInterface);
    }

    public static <T> T getBean(String name, Class<T> beanInterface) {
        if (applicationContext == null) {
            throw new IllegalStateException("Application context is not initialized. Call one of init() methods prior to calling getBean()");
        }
        return applicationContext.getBean(name, beanInterface);
    }
}
