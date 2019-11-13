package com.biefeng.spring.test;

import com.biefeng.spring.LogUtil;
import com.biefeng.spring.bean.Cigarette;
import com.biefeng.spring.config.SpringConfiguration1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author : BieFeNg
 * @DATE : 2018/9/17 21:35
 */
public class MainT {

    private static Logger logger = LoggerFactory.getLogger(MainT.class);


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SpringConfiguration1.class);
        ctx.refresh();
        Cigarette cigarette = (Cigarette) ctx.getBean("cigarette");
        logger.info("------cigarette：{}",cigarette);
    }
}
