package com.biefeng.thinkInJava.generic;

public class FactoryConstraint {
    public static void main(String[] args) {
        System.out.println(new Foo2(new IntegerFactory()).getT().getClass().getSimpleName());
    }
}

interface Factory<T> {
    T create();
}

class Foo2<T> {
    private T t;

    public <F extends Factory<T>> Foo2(F factory) {
        t = factory.create();
    }

    public T getT() {
        return t;
    }
}

class IntegerFactory implements Factory<Integer> {

    @Override
    public Integer create() {
        return new Integer(0);
    }
}

class Widget {
    private static class InnerFactory implements Factory<Widget> {
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}