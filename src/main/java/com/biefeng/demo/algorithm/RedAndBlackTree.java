
package com.biefeng.demo.algorithm;

import org.junit.Test;

public class RedAndBlackTree {
/*
    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private Node root;

    //左旋
    private void leftRotate(Node x) {
        Node y = x.rightChild;
        if (y.leftChild != null) {
            y.leftChild.parent = x;
            x.rightChild = y.leftChild;
        }
        y.parent = x.parent;

        if (x.parent == null) {
            this.root = y;
        } else {
            if (x.parent.leftChild == x) {
                x.parent.leftChild = y;
            } else {
                x.parent.rightChild = y;
            }
        }
        y.leftChild = x;
        x.parent = y;
    }

    //右旋
    private void rightRotate(Node x) {
        Node y = x.leftChild;
        y.parent = x.parent;
        if (y.rightChild != null) {
            y.rightChild.parent = x;
            x.leftChild = y.rightChild;
        }
        if (x.parent == null) {
            this.root = y;
        } else {
            if (x.parent.leftChild == x) {
                x.parent.leftChild = y;
                y.parent = x.parent;
            } else {
                x.parent.rightChild = y;
                y.parent = x.parent;
            }
        }
        y.rightChild = x;
        x.parent = y;

    }

    public void insert(Node node) {
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (true) {
            if ((node.key.compareTo(current.key)) < 0) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    node.parent = current;
                    break;
                } else {
                    current = current.leftChild;
                }
            } else if ((node.key.compareTo(current.key) > 0)) {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    node.parent = current;
                    break;
                } else {
                    current = current.rightChild;
                }
            } else {
                System.out.println("该节点已存在。");
                break;
            }
        }
        //定义父节点和祖父节点
        Node parent, grandParent;
        while ((parent = node.parent) != null && parent.color == RED) {
            grandParent = parent.parent;
            if (parent == grandParent.leftChild) {
                Node uncle = grandParent.rightChild;//获得叔叔

                if (uncle != null) {

                    //情况1：叔叔和父亲的颜色一致，都为红色
                    if (uncle.color == RED) {
                        uncle.color = BLACK;
                        parent.color = BLACK;
                        grandParent.color = RED;
                        node = grandParent;
                        continue;
                    }
                    //情况2：叔叔节点是黑色，且当前节点是右子节点
                    if (uncle.color == BLACK && node == parent.rightChild) {
                        leftRotate(parent);
                        //将父子节点对调，以便后续的右旋
                        Node tem = parent;
                        parent = node;
                        node = parent;
                        continue;
                    }
                    //情况3：叔叔节点是黑色，且当前节点是左子节点
                    rightRotate(parent);
                    Node tem = parent;
                    parent = node;
                    node = tem;
                    continue;
                }else{
                    rightRotate(parent);

                }



            } else {

            }
        }
    }

    private class Node<T extends Comparable<T>> {
        boolean color;

        T key;
        Node<T> parent;
        Node<T> leftChild;
        Node<T> rightChild;

        public Node(boolean color, T key, Node<T> parent, Node<T> leftChild, Node<T> rightChild) {
            this.color = color;
            this.key = key;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public T getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "" + key + (this.color == RED ? "R" : "B");
        }
    }

    @Test
    public void testInsert() {
        Node a = new Node(RED, 1, null, null, null);
        Node b = new Node(RED, 2, null, null, null);
        Node c = new Node(RED, 3, null, null, null);
        Node d = new Node(RED, 4, null, null, null);
        Node e = new Node(RED, 5, null, null, null);
        Node f = new Node(RED, 6, null, null, null);

        RedAndBlackTree redAndBlackTree = new RedAndBlackTree();
        redAndBlackTree.insert(a);
        redAndBlackTree.insert(b);
        redAndBlackTree.insert(c);
        redAndBlackTree.insert(d);
        redAndBlackTree.insert(e);
        System.out.println(redAndBlackTree.root.rightChild.key);
    }
*/
}


