package com.biefeng.demo.io.serialize;

import java.io.*;

public class TestSerialize {
    public static void main(String args[]) {
        try
        {
            A a = new A();
            a.setA("BieFeNg");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("e:test"));
            objectOutputStream.writeObject(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class A implements Serializable{

    private String a;
    private static int b;

    static {
        b = 1;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
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

