package com.biefeng.thinkInJava.enums;

public enum Ozwitch {

    //Instace must be defined first,before the field description and the method declared
    WEST("Miss  Gulch ,aka the Wicked Witch of the WEST"),
    NORTH("Glinda,the good witch of the North"),
    EAST("Wicked Witch of the East,wearer of the Ruby Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference,but missing");

    private String description;


    private Ozwitch(String s) {
        this.description = s;
    }

    public String getDescription() {
        return this.description;
    }

    public static void main(String[] args) {
        for(Ozwitch o:Ozwitch.values()){
            System.out.println(o+": "+o.getDescription());
        }
    }
}
