package com.biefeng.demo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TestScanner {

    public static void main(String[] args) throws FileNotFoundException {

        try(Scanner s = new Scanner(new BufferedReader(new FileReader("H:\\workspace\\idea\\Test\\src\\main\\java\\com\\biefeng\\demo\\io\\test.txt")));){
            File file = new File("");
            System.out.println(file.getAbsolutePath());
            while (s.hasNext()){
                System.out.println(s.next());
            }
        }
    }
}
