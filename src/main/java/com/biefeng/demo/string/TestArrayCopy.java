package com.biefeng.demo.string;

import com.biefeng.demo.algorithm.MyBinaryTree;
import org.junit.Test;

import java.util.Arrays;


public class TestArrayCopy {

    MyBinaryTree tree =new MyBinaryTree();


    @Test
    public void test11(){
        Object arr1[]={1,2L,tree,"","biefeng"};
       Object arr2[] = Arrays.copyOf(arr1,3,arr1.getClass());
        System.out.println(arr1.getClass().getSimpleName());
        try {
            Class clazz=Class.forName("[Ljava.lang.String;");

         //   System.out.println(clazz.newInstance());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}


