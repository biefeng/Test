package com.biefeng.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author : BieFeNg
 * @DATE : 2018/9/19 21:48
 */
public class BlackListEvent extends ApplicationEvent {

    private String address;
    private String content;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public BlackListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }



}
