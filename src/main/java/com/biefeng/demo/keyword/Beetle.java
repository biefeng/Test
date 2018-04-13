package com.biefeng.demo.keyword;

class Insect {
    private int i = 9;
    protected int j;

    Insect() {//类的构造方法其实也是初始化，
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 = printInit("static Insect.x1 initialized");


    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

public class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j =" + j);
    }

    private static int x2 = printInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        System.out.println("Beetle Constructor");
        Beetle b = new Beetle();
    }
}
/*

 */
/*
output:

    1,static Insect.x1 initialized //当访问Beetle的main方法时，触发类Beetle的初始化，在初始化Beetle之前会触发Insect的初始化，在初始化之前会加载类，类加载时完成静态初始化
    2,static Beetle.x2 initialized //触发Beetle加载时的静态初始化
    3,Beetle Constructor //而后开始执行System.out.println("Beetle Constructor")
    4,i = 9, j =0 //先初始化父类，但在执行System.out.println("i = " + i + ", j = " + j);时，j还未被显示的初始化，所以j的值还是类加载时在准备阶段为其赋的默认值0
    5,Beetle.k initialized//在指向Beetle的无参构造器时，因使用到了k就会触发k的显示初始化，所以执行了    private int k = printInit("Beetle.k initialized");
    6,k=47
    7,j=39
 */
