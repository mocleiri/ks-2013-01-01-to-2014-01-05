package com.sigmasys.bsinas.service.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Service;

/**
 * AopBeanFactoryPostProcessor
 *
 * @author Michael Ivanov
 *         Date: 5/31/12
 */
@Service
public class AopBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if ( beanFactory instanceof DefaultListableBeanFactory) {
           ((DefaultListableBeanFactory)beanFactory).setAllowRawInjectionDespiteWrapping(true);
        }
    }
}
