package com.biefeng.demo.algorithm;

import org.junit.Test;


public class QuickSort {

    public int getMiddle(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high) {
            while (low < high && arr[high] > key) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= key) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = key;
        return low;
    }

    public void sort(int arr[], int low, int high) {
        if (low < high) {
            int m = getMiddle(arr, low, high);
            sort(arr, low, m - 1);
            sort(arr, m + 1, high);
        }

    }

    @Test
    public void testGetMiddle() {
        int[] arr = {5, 2, 6, 4, 1, 3, 31, 25, 131, 15, 13, 1, 1, 3, 5, 54, 65, 12, 21, 14, 16, 13, 14, 12, 21, 24, 26, 27, 63, 36, 35, 34};
        // System.out.println(getMiddle(arr, 0, arr.length - 1));
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    @Test
    public void testBinarySort() {
        int[] arr = {5, 2, 6, 4, 1, 3, 31, 25, 131, 15, 13, 1, 1, 3, 5, 54, 65, 12, 21, 14, 16, 13, 14, 12, 21, 24, 26, 27, 63, 36, 35, 34};

        MyBinaryTree myBinaryTree = new MyBinaryTree();
        for (int i = 0; i < arr.length; i++) {
            MyBinaryTree.Node node = myBinaryTree.new Node(arr[i],Integer.toString(arr[i]));
            myBinaryTree.insert(node);
        }
        myBinaryTree.traversalTree(MyBinaryTree.TraversalType.INORDER);
        sort(arr,0,arr.length-1);
        System.out.println();
        for(int i:arr){
            System.out.print(i+",");
        }
    }
}
