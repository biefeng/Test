package com.biefeng.demo.algorithm;


import org.junit.Test;

public class MyBinaryTree {
    private Node root;

    public MyBinaryTree() {
        root = null;
    }

    /*寻找节点*/
    public Node find(int key) {
        Node currentNode = root;
        if (currentNode == null) {
            System.out.println("根节点为空");
            return null;
        } else {
            while (true) {

                if (currentNode.leftChild != null && currentNode.key > key) {
                    currentNode = currentNode.leftChild;
                } else if (currentNode.rightChild != null && currentNode.key < key) {
                    currentNode = currentNode.rightChild;
                } else if (currentNode.key == key) {
                    System.out.println(currentNode.data);
                    return currentNode;

                } else {
                    System.out.println("查找完成，但未找到节点");
                    return null;
                }

            }
        }
    }

    /*插入节点*/
    public void insert(Node node) {
        if (root == null)
            root = node;
        else {
            Node current = root, parent;
            while (true) {
                parent = current;
                if (parent.key > node.key) {//判断插入的节点值，以满足左子节点小于根节点的性质
                    if (parent.leftChild == null) {//判断当前节点的左子节点是否为空，如果为空，则将节点作为当前节点的左子节点插入。
                        parent.leftChild = node;
                        node.parent = parent;//将当前节点作为父节点
                        break;
                    } else {
                        current = parent.leftChild;//如果当前节点的左子节点不为空，则向左子节点循环。
                    }
                } else {
                    if (parent.rightChild == null) {
                        parent.rightChild = node;
                        node.parent = parent;
                        break;
                    } else {
                        current = parent.rightChild;
                        node.parent = parent;
                    }
                }
            }
        }
    }

    /**
     * 二叉遍历的枚举类型
     */
    enum TraversalType {
        PREORDER,
        INORDER,
        POSETORDER
    }

    /**
     * 根据类型调用相应遍历方法
     *
     * @param type
     */
    public void traversalTree(TraversalType type) {
        switch (type) {
            case PREORDER:
                preOrder(root);
                break;
            case INORDER:
                inOrder(root);
                break;
            case POSETORDER:
                postOrder(root);
                break;
        }
    }

    /**
     * 先序遍历
     *
     * @param localRoot
     */
    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.println(localRoot.data.toString()+",");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    /**
     * 中序遍历
     *
     * @param localRoot
     */
    private void inOrder(Node localRoot) {
        if (null != localRoot) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.data.toString()+",");
            inOrder(localRoot.rightChild);
        }
    }

    /**
     * 后序遍历
     *
     * @param localRoot
     */
    private void postOrder(Node localRoot) {

        if (null != localRoot) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.println(localRoot.data.toString()+",");
        }
    }

    /*寻找最小节点*/
    public Node minNode() {

        Node current = root, parent = root;

        while (current != null) {
            parent = current;
            current = parent.leftChild;
        }

        return parent;
    }

    /*
    寻找最大节点
     */
    public Node maxNode() {
        Node current = root, parent = root;
        while (current != null) {
            parent = current;
            current = current.rightChild;
        }
        return parent;
    }

    /**
     * 删除给点值的节点
     *
     * @param key
     */
    public void delete(int key) {
        Node node = find(key);
        if (node == null) {
            System.out.println("未找到节点");
            return;
        }
        int[] c = {1, 1};
        if (node.leftChild == null) {
            c[0] = 0;
        }
        if (node.rightChild == null) {
            c[1] = 0;
        }

        if ((c[1] + c[0]) == 1) {
            if (node.rightChild != null) {
                if (node.parent.rightChild == node) {
                    node.parent.rightChild = node.rightChild;
                    node.rightChild.parent = node.parent;
                    System.out.println("成功删除:" + node.key);
                } else {
                    node.parent.leftChild = node.rightChild;
                    node.rightChild.parent = node.parent;
                    System.out.println("成功删除:" + node.key);
                }
            } else {
                if (node.parent.leftChild == node) {
                    node.parent.leftChild = node.leftChild;
                    node.leftChild.parent = node.parent;
                    System.out.println("成功删除:" + node.key);

                } else {
                    node.parent.rightChild = node.leftChild;
                    node.leftChild.parent = node.parent;
                    System.out.println("成功删除" + node.key);
                }
            }
        }
        if ((c[0] + c[1]) == 0) {
            if (node.parent.leftChild == node) {
                node.parent.leftChild = null;
                System.out.println("成功删除:" + node.key);
            } else {
                node.rightChild = null;
                System.out.println("成功删除" + node.key);
            }
        }
        if ((c[0] + c[1]) == 2) {
            Node currentNode = node.rightChild;
            if (currentNode.leftChild == null) {
                if (node.parent.leftChild == node) {
                    node.parent.leftChild = node.rightChild;
                    node.rightChild.parent = node.parent;
                    node.rightChild.leftChild = node.leftChild;
                    System.out.println("成功删除" + node.key);
                } else {
                    node.parent.rightChild = currentNode;
                    currentNode.parent = node.parent;
                    System.out.println("成功删除" + node.key);
                }
            } else {
                while (currentNode.leftChild != null) {
                    currentNode = currentNode.leftChild;
                }
                if (node.parent.leftChild == node) {
                    node.parent.leftChild = currentNode;
                    currentNode.parent = node.parent;
                    currentNode.leftChild = node.leftChild;
                    currentNode.rightChild = node.rightChild;
                    System.out.println("成功删除" + node.key);
                } else {
                    node.parent.rightChild = currentNode;
                    currentNode.parent = node.parent;
                    currentNode.leftChild = node.leftChild;
                    currentNode.rightChild = node.rightChild;
                    System.out.println("成功删除" + node.key);
                }
            }

        }


    }

    public static void main(String args[]) {
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        Node a = myBinaryTree.new Node(10, "我是10");
        Node b = myBinaryTree.new Node(5, "我是5");
        Node c = myBinaryTree.new Node(20, "我是20");
        Node d = myBinaryTree.new Node(21, "我是21");
        Node e = myBinaryTree.new Node(17, "我是17");
        Node f = myBinaryTree.new Node(15, "我是15");
        Node g = myBinaryTree.new Node(30, "我是30");
        myBinaryTree.insert(a);
        myBinaryTree.insert(g);
        /*a.leftChild=b;
        a.rightChild=c;
        c.leftChild=e;
        c.rightChild=d;*/
        myBinaryTree.insert(b);
        myBinaryTree.insert(c);
        myBinaryTree.insert(d);
        myBinaryTree.insert(e);
        myBinaryTree.insert(f);

        myBinaryTree.traversalTree(TraversalType.PREORDER);
        System.out.println("------------");
        Node minNode = myBinaryTree.minNode();
        Node maxNode = myBinaryTree.maxNode();
        System.out.println("最小的节点为：" + minNode.data);
        System.out.println("最大的节点为：" + maxNode.data);
        myBinaryTree.delete(20);
        myBinaryTree.traversalTree(TraversalType.PREORDER);
    }

    public class Node {
        int key;
        Object data;
        Node parent;
        Node leftChild;
        Node rightChild;

        Node(int key, Object o) {
            this.key = key;
            this.data = o;
        }

    }

    @Test
    public void testDelete() {
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        Node a = myBinaryTree.new Node(10, "我是10");
        Node b = myBinaryTree.new Node(5, "我是5");
        Node c = myBinaryTree.new Node(20, "我是20");
        Node d = myBinaryTree.new Node(21, "我是21");
        Node e = myBinaryTree.new Node(17, "我是17");
        Node f = myBinaryTree.new Node(15, "我是15");
        Node g = myBinaryTree.new Node(30, "我是30");
        myBinaryTree.insert(a);
        myBinaryTree.insert(g);
        /*a.leftChild=b;
        a.rightChild=c;
        c.leftChild=e;
        c.rightChild=d;*/
        myBinaryTree.insert(b);
        myBinaryTree.insert(c);
        myBinaryTree.insert(d);
        myBinaryTree.insert(e);
        myBinaryTree.insert(f);
        myBinaryTree.find(56);
    }


}

