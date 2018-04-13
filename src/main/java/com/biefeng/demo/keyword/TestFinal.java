package com.biefeng.demo.keyword;

import org.junit.Test;

import java.lang.reflect.Method;

public class TestFinal {
    public void  method1(final TestFinalChild finalChild){//对于final修饰的形参，无法在方法中进行修改参数引用所指向的对象，但可以修改所指向的对象的内容。（主要用于向匿名内部类传递参数）
        finalChild.name="biefen";
        System.out.println("this is public method1: "+finalChild.name);
    }

    public void changeInt(int i){
        i=100;
        System.out.println(i);
    }

    public void changeObj(TestFinalChild testFinal){
        testFinal=new TestFinalChild();
        System.out.println(testFinal);
    }

    private void method2(){
        System.out.println("this is private method2");
    }

    public final  void method3(){
        System.out.println("This is public final method3");
    }

    private final void method4(){
        System.out.println("this is private final method2");
    }//被final或private修饰的方法不会被重写（final的不可改变性以及private的不可访问性，private修饰的方法默认被指定为final）

    @Test
    public void test(){
        TestFinalChild f = new TestFinalChild();
        Method[] ms= f.getClass().getMethods();
    for (Method m:ms){
        System.out.println(m.getName());
    }
    }

    @Test
    public void test2() {
        String name ="bifeng";
        TestFinal f = new TestFinal();
        TestFinalChild f1= new TestFinalChild();
        f.method1(f1);
        System.out.println(f1.name);//

    }

    @Test
    public void test3() {
        int i=10;
        TestFinal testFinal = new TestFinal();
        testFinal.changeInt(i);
        System.out.println(i);//java只有值传递，对于基本类型，直接copy一份值，所以对于修改不会影响到值本身
    }

    @Test
    public void test4() {
        TestFinalChild testFinalChild = new TestFinalChild();
        TestFinal testFinal=new TestFinal();

        testFinal.changeObj(testFinalChild);
        System.out.println(testFinalChild);//对于引用类型，同样也是复制引用的值，所以将参数执行新的对象也不会改变原引用，但对引用所指对象所做的修改产生影响。
    }
}

class TestFinalChild extends TestFinal{

    String name="biefeng";

    public void method4(){}
}

