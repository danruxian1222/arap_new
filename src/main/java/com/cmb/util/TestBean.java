package com.cmb.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class TestBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,
        BeanPostProcessor, InitializingBean, DisposableBean {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("#########################setBeanFactory");

    }

    @Override
    public void setBeanName(String s) {
        System.out.println("#########################setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("#########################destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("#########################afterPropertiesSet");
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("#########################postProcessBeforeInitialization");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("#########################postProcessAfterInitialization");
        return o;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("#########################setApplicationContext");
    }
}
