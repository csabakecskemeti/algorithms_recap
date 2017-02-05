package com.robi1;

import com.sun.tools.javac.util.Pair;

/**
 * Created by kecso on 2/5/17.
 */
public class Tree2LinkestListDemo {

    public static void main(String[] args) {
        // create tree
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(4);
        a.left = b;
        TreeNode c = new TreeNode(5);
        b.right = c;
        TreeNode d = new TreeNode(1);
        b.left = d;
        TreeNode e = new TreeNode(12);
        a.right = e;
        TreeNode f = new TreeNode(10);
        e.left = f;
        TreeNode g = new TreeNode(13);
        e.right = g;

        System.out.println("In Order Traversal of binary search tree");
        Tree2LinkedList.inOrderTraversal(a);
        System.out.println("\nBinary search tree 2 Linked list");
        Pair<TreeNode, TreeNode> myList = Tree2LinkedList.inPlaceTree2LinkedList(a);
        TreeNode head = myList.fst;
        while(head != null) {
            System.out.println(head.getValue());
            head = head.right;
        }

        System.out.println("Rev list");
        TreeNode tail = myList.snd;
        while(tail != null) {
            System.out.println(tail.getValue());
            tail = tail.left;
        }
    }
}
