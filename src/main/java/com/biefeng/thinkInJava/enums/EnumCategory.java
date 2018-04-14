package com.biefeng.thinkInJava.enums;

//创建枚举类时，编译器会为此生成一个继承自java.lang.Enum的相关类
public class EnumCategory {
    public static void main(String[] args) {
        for (Category c : Category.values()) {
            System.out.println(c + "ordinal : " + c.ordinal());//values()静态方法返回的数组中的元素顺序按照枚举类中定义的顺序。
            System.out.println(c.compareTo(Category.CRAWING));//
            System.out.println(c.equals(Category.CRAWING));
            System.out.println(c == Category.CRAWING);
            System.out.println(c.name());
            System.out.println(c.getDeclaringClass());
            System.out.println(c.getClass().getSuperclass().getTypeName());
            System.out.println("--------------");
        }

        for (String s : "GROUND CRAWING HANGING".split(" ")) {
            Category category = Enum.valueOf(Category.class, s);
            System.out.println(category);
        }

    }
}

enum Category {
    GROUND, CRAWING, HANGING
}
