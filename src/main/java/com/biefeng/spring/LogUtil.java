package com.biefeng.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author : BieFeNg
 * @DATE : 2018/9/17 23:44
 */
public class LogUtil {

    public static void debug(Class clazz,String msg, Object... obj) {
        LoggerFactory.getLogger(clazz).debug(msg, obj);
    }

    public static void info(Class clazz,String msg, Object... obj) {
        LoggerFactory.getLogger(clazz).info(msg, obj);
    }

    public static void error(Class clazz,String msg, Object... obj) {
        LoggerFactory.getLogger(clazz).error(msg, obj);
    }
}
