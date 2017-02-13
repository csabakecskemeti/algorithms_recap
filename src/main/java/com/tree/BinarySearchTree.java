package com.tree;

/**
 * Created by kecso on 2/12/17.
 */
public class BinarySearchTree {
    Node root;

    public void add(Node sNode, Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            if (sNode.value < newNode.value) {
                if(sNode.right == null) {
                    sNode.right = newNode;
                } else {
                    add(sNode.right, newNode);
                }
            } else {
                if(sNode.left == null) {
                    sNode.left = newNode;
                } else {
                    add(sNode.left, newNode);
                }
            }
        }
    }

    public void search(Node sNode, int value) {
        if (sNode == null) {
            System.out.println("value " + value + " not exist");
            return;
        }
        if(sNode.value == value) {
            System.out.println(value + " found");
        } else if(sNode.value < value){
            search(sNode.right, value);
        } else {
            search(sNode.left, value);
        }
    }

    public void inOrderTraversal(Node root) {
        if (root != null) {
            if (root.left != null) {
                inOrderTraversal(root.left);
            }
            System.out.println(root.value);
            if (root.right != null) {
                inOrderTraversal(root.right);
            }
        }
    }
}
