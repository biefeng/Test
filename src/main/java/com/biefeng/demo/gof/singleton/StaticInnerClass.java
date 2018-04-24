package com.biefeng.demo.gof.singleton;

public class StaticInnerClass {


    private StaticInnerClass() {
    }

    private StaticInnerClass getInstace() {
        return InnerClass.INSTANCE;
    }

    private static class InnerClass {
        private static final StaticInnerClass INSTANCE = new StaticInnerClass();
    }
}
