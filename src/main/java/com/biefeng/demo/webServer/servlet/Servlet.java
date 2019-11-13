package com.biefeng.demo.webServer.servlet;

public interface Servlet {

    void init();

    void doService();

    void destroy();
}
