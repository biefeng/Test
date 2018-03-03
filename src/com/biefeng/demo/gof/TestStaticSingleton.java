package com.biefeng.demo.gof;

public class TestStaticSingleton {
    private TestStaticSingleton (){}
    private static class TestStaticSingleInstance{
      static TestStaticSingleton  INSTANCE = new TestStaticSingleton();
    }

    public static TestStaticSingleton getInsatance(){
        return TestStaticSingleInstance.INSTANCE;
    }
}
