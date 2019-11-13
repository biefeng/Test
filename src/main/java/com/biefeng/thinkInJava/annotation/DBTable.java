package com.biefeng.thinkInJava.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited //允许子类继承
@Documented 
public @interface DBTable {
    String name() default "";
}
