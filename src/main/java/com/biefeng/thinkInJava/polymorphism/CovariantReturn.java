package com.biefeng.thinkInJava.polymorphism;


//协变返回，不支持协变类型，则第二次输出还是为Grain，协变返回则支持第二次输出Wheat
public class CovariantReturn {

    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);
        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
}

class Grain {
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {

    public String toString() {
        return "Wheat";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {
    Wheat process() {
        return new Wheat();
    }
}


