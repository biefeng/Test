package com.biefeng.demo.teststatic;

public class TestStatic {
    public static void main(String[] args) {
        System.out.print(FinalStatic.a);
        FinalStatic finalStatic =  new FinalStatic();
        System.out.println(finalStatic.returnb());
        
    }
}

class FinalStatic {
    public static final int a = 4 + 4;
    public static int b;

    static {
        System.out.println("如果执行了，证明被类被初始化了！");
    }

    public int returnb(){
        b=2;
        return b;
    }
}
