package com.biefeng.demo.keyword;

import java.util.Arrays;
import java.util.Random;

public class InitializeFinalField {

    private static Random rand = new Random(47);
    private String id;

    private final int valueField;//空白final

    public InitializeFinalField(String id) {
        this.id = id;
        this.valueField = 0;//也可调用构造器进行初始化
    }

    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;

    public static final int VALUE_THREE = 39;
    private final int i4 = rand.nextInt(20);//对于final修饰的field并不一定会在编译期就知晓值，可调用方法在运行时进行初始化。
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);





    private final int[] a = {1, 2, 3, 4, 5, 6, 7};

    @Override
    public String toString() {
        return "InitializeFinalField{" +
                "id='" + id + '\'' +
                ", i4=" + i4 +
                ", INT_5="+INT_5+
                '}';
    }

    public static void main(String[] args) {
        InitializeFinalField field = new InitializeFinalField("fd1");
        // field.valueOne++;//cannot be changed
        field.v2.i++;
        field.v1=new Value(9);

        for (int i=0;i<field.a.length;i++){
            field.a[i]++;
        }
        //field.v2=new Value(1);//cannot be changed
        //field.VAL_3=new Value(12);//cannot be changed
        //field.a=new int[3];

        System.out.println(field);
        System.out.println("Create new InitializeFinalField");
        InitializeFinalField field1 = new InitializeFinalField("field1");
        System.out.println(field);
        System.out.println(field1);

    }
}

class Value {
    int i;

    public Value(int i) {
        this.i = i;
    }
}