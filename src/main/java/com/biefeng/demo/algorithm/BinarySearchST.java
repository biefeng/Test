package com.biefeng.demo.algorithm;

/**
 * 二叉查找树实现有序符号表
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    /*private Key[] keys;
    private Value[] values;
    private int n;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return this.n;
    }

    public Value getKey(Key key) {
        int mid = rank(key);
        if (mid < n && keys[mid].compareTo(key) == 0)
            return values[mid];
        return null;
    }

    public int rank(Key key) {
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp == 0)
                return mid;
            else if (cmp < 0)
                high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            values[i] = value;
            return;
        }
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
            n++;
        }
    }

    public Key celling(Key key) {
        int i = rank(key);
    }
*/
}
