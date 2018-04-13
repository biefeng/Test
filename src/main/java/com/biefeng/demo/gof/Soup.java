
package com.biefeng.demo.gof;

public class Soup {
    private static Soup soup = new Soup();
    public static Soup getSoup(){
        return soup;
    }

    public static void main(String[] args) {
        Soup soup1=Soup.getSoup();
        Soup soup2=Soup.getSoup();
        Soup soup3=new Soup();
        System.out.println(soup1==soup2);
        System.out.println(soup1==soup3);
    }
}



