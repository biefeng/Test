package com.biefeng.thinkInJava.generic;

public class GenericArray<T> {
    private T[] array;

    public GenericArray(int size) {
        array = (T[]) new Object[size];
    }

    public T getT(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> ga1=new GenericArray<>(10);
        Object[] oa=ga1.rep();
        Integer[] ia=ga1.rep();
    }
}
