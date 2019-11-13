package com.biefeng.spring.config;

import com.biefeng.spring.bean.Cigarette;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author : BieFeNg
 * @DATE : 2018/9/17 21:27
 */
@Configuration
@ComponentScan(basePackages = "com.biefeng.spring")
@EnableAspectJAutoProxy
public class SpringConfiguration1 implements BeanPostProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringConfiguration1.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.info("--------------Before the bean: {} is created-------------", bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.info("--------------After the bean: {} is created", bean);
        return bean;
    }

}
