package com.biefeng.demo.io.serialize;

import java.io.*;

public class TestSerialize {
    static Object object  =new Object();
    static A a;

    public static void main(String args[]) {
        try {
            TestSerialize.a=new A();
            a.setA("BieFeNg");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("e:test"));
            objectOutputStream.writeObject(a);
            //System.out.println(object.toString());
            System.out.println(new A().getA());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class A implements Serializable {

    private static String a;
    private static int b;

    /*static {
        b = 1;
    }*/

    public String getA() {
        return a;
    }

    public static void setA(String a) {
        A.a = a;
    }

    public static int getB() {
        return b;
    }

    public static void setB(int b) {
        A.b = b;
    }

    @Override
    public String toString() {
        return "a:" + this.a + ",b:" + this.b;
    }
}

