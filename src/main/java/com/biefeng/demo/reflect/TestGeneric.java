package com.biefeng.demo.reflect;

import com.biefeng.demo.algorithm.MyBinaryTree;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.lang.annotation.*;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class TestGeneric {

    @Test
    public void test(){
        Class clazz;

        {
            try {
                clazz = Class.forName("com.biefeng.demo.reflect.UserDao");
               UserDao us = (UserDao) clazz.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() {
        try {
            Class clazz = Class.forName("com.biefeng.demo.reflect.CategroyDao");
            ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
            System.out.println(parameterizedType.getActualTypeArguments()[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Dao<T>{
    private Class<T> beanClass;

    public Dao(){
        //Dao<T> dao = new Dao<T>();
        System.out.println("Dao "+ this);
        ParameterizedType type =  (ParameterizedType)this.getClass().getGenericSuperclass();
        beanClass =  (Class<T>)type.getActualTypeArguments()[0];
        System.out.println("dao<T>：" + beanClass.getName());

        System.out.println(this.getClass().getSuperclass().getName());

    }
}

class UserDao extends Dao<Book>{
    public UserDao(){
        System.out.println("bookDao:" + this);
    }
}

class Book {

}

