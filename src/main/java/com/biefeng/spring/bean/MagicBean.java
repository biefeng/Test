package com.biefeng.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @Author BieFeNg
 * @Date 2018-06-06 20:49
 * @Desc
 */
public class MagicBean {

    @Bean
    @Conditional(MagicExistCondition.class)
    public MagicBean magicBean(){
        return new MagicBean();
    }
}
