package com.biefeng.spring.bean;

import com.biefeng.spring.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Author : BieFeNg
 * @DATE : 2018/9/17 21:29
 */
@Component
@Lazy
public class Cigarette implements InitializingBean {


    private String guid;

    private String name;

    private double price;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        LogUtil.info(this.getClass(),"The bean: cigarette has been initialized!");
    }
}
