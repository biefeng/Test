package com.biefeng.demo.teststatic;

public class SingletonPattern6 {

    //和饿汉式机制类似，都是采用类装仔机制进行实例化，不同的时饿汉式只要类被加载就进行实例化，

 //   private static final com.biefeng.demo.teststatic.SingletonPattern6=;

  private SingletonPattern6(){

  }

  static class SingletonPatternInstance{
    private static   final SingletonPattern6 INSTANCE = new SingletonPattern6();
  }

  public static SingletonPattern6 getInstance(){
      return SingletonPatternInstance.INSTANCE;
  }
}
