package com.biefeng.spring.event;

import org.springframework.context.event.EventListener;

/**
 * @Author : BieFeNg
 * @DATE : 2018/9/19 22:31
 */
public class BlackListNotifierWithAnnotation {

    private String notificationAddress;

    @EventListener()
    public void processBlackListEvent(BlackListEvent event){}
}
