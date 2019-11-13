package com.biefeng.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * @Author : BieFeNg
 * @DATE : 2018/9/19 21:59
 */
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {
    private String notificationAddress;


    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlackListEvent event) {

    }
}
