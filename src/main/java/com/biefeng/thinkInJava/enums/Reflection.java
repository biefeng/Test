package com.biefeng.thinkInJava.enums;

import com.biefeng.thinkInJava.OSExecute;
import sun.misc.OSEnvironment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//枚举中的静态方法values(),在java.lang.Enum中并没有声明。
public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {

        System.out.println("-------Analyzing " + enumClass + "------");
        System.out.println("Interfaces:");
        for (Type type : enumClass.getInterfaces()) {
            System.out.println(type);
        }
        System.out.println("Base:" + enumClass.getSuperclass());
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> explorMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explor.containAll(Enum) ? " + explorMethods.containsAll(enumMethods));
        System.out.println("Explor.removeAll(Enum) : ");
        explorMethods.removeAll(enumMethods);
        System.out.println(explorMethods);
        // String packageName=Explore.class.getPackage().getName();
        String classPath = Explore.class.getResource("/").getPath();
        System.out.println(classPath);
        String dir = classPath.substring(1);
        System.out.println(dir);
        // OSExecute.command(cdCommand);
        OSExecute.command("javap com/biefeng/thinkinjava/enums/Explore", dir);
        System.out.println(Explore.class.getResource("/").toString());
       /* try {
          Process process=  Runtime.getRuntime().exec("CMD /C"+"javap com/biefeng/thinkinjava/enums/Explore");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
            while ((bufferedReader.readLine())!=null)
                System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*try {
            String command[]  ={"CMD","/C","javap" ," ","com"};
            System.out.println(1111);
            Process process1 = Runtime.getRuntime().exec(command);
            BufferedReader error = new BufferedReader(new InputStreamReader(process1.getInputStream(),"GBK"));
           String s;
            while ((s=error.readLine())!=null)
                System.out.println(s);
            System.out.println("End!");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}

enum Explore {
    HERE, THERE
}