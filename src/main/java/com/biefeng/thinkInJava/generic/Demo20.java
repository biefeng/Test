package com.biefeng.thinkInJava.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo20<T extends Bound> {
    private T obj;



    public void call(T t){
        for(Method m:t.getClass().getDeclaredMethods()){
            try {
                m.invoke(t.getClass().newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Demo20<BoundImpl> d = new Demo20<>();
        d.call(new BoundImpl());
    }
}
interface Bound{
    void sayHello();
    void sayGoogBye();
}
class BoundImpl implements Bound{
    @Override
    public void sayHello() {
        System.out.println("BoundImpl.sayHello()");
    }

    @Override
    public void sayGoogBye() {
        System.out.println("BoundImpl.sayGoodBye()");
    }

    public void theOtherMethod(){
        System.out.println("BoundImpl.theOtherMethod()");
    }
}