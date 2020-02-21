package com.cmb.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.StringValueResolver;

import java.io.IOException;
import java.util.Properties;

/*public class ConfigFileInfoUtil extends PropertiesFactoryBean {*/

public class ConfigFileInfoUtil extends PropertyPlaceholderConfigurer {

    private Properties props;


    public void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess,props);

        this.props = props;

        props.list(System.out);
    }

}
