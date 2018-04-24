package com.biefeng.thinkInJava.generic;

import java.util.HashMap;
import java.util.Map;

public class ClassTypeCapture<T> {
    Class<T> kind;
    private Map<String, Class<?>> types;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public ClassTypeCapture(Class<T> kind, Map<String, Class<?>> types) {
        this.kind = kind;
        this.types = types;
    }

    public void addType(String typeName, Class<?> kind) {
        types.put(typeName, kind);
    }

    public Object createNew(String typeName) throws IllegalAccessException, InstantiationException {

        if (types.containsKey(typeName))
            return types.get(typeName).newInstance();
        else
            System.out.println(typeName + " class not available");
        return null;
    }

    public boolean f(Object obj) {
        return kind.isInstance(obj);
    }

    public static void main(String[] args) {
        ClassTypeCapture classTypeCapture1 = new ClassTypeCapture(Building.class);
        System.out.println(classTypeCapture1.f(new Building()));
        System.out.println(classTypeCapture1.f(new House()));

        ClassTypeCapture classTypeCapture2 = new ClassTypeCapture(House.class);
        System.out.println(classTypeCapture2.f(new Building()));
        System.out.println(classTypeCapture2.f(new House()));

        ClassTypeCapture<Building> classTypeCapture3 = new ClassTypeCapture<>(Building.class, new HashMap<>());
        classTypeCapture3.addType("House", House.class);
        classTypeCapture3.addType("Building", Building.class);
        System.out.println("classTypeCapture3.types: " + classTypeCapture3.types);

        System.out.println("-----------------");
        try {
            Building b = (Building) classTypeCapture3.createNew("Building");
            House h = (House) classTypeCapture3.createNew("House");
            System.out.print("b.getClass().getName(): ");
            System.out.println(b.getClass().getName());
            System.out.print("h.getClass().getName(): ");
            System.out.println(h.getClass().getName());
            System.out.print("House h is instance House: ");
            System.out.println(h instanceof House);
            System.out.print("House h is instance of Building: ");
            System.out.println(h instanceof Building);
            System.out.print("Building b is instance of House: ");
            System.out.println(b instanceof House);
            classTypeCapture3.createNew("String");  // String class not available
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException in main");
        } catch (InstantiationException e) {
            System.out.println("InstantiationException in main");
        }
    }
}

class Building {
}

class House extends Building {
}