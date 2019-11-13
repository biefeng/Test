package com.biefeng.demo.algorithm;

import java.util.Random;

public class Bubble_Sort {
    public static void sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }

            }
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(20);
            System.out.print(arr[i] + ",");
        }
        Bubble_Sort.sort(arr);
        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
