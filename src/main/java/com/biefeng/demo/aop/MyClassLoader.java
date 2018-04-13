package com.biefeng.demo.aop;

import org.objectweb.asm.Opcodes;

public class MyClassLoader extends ClassLoader implements Opcodes {
    public MyClassLoader() {
    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    public Class<?> defineClass(String name,byte[] b){
        return super.defineClass(name,b,0,b.length);
    }
}
