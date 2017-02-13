package com.tree;

/**
 * Created by kecso on 2/12/17.
 */
public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        System.out.println("BST demo");
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(bst.root, new Node(5));
        bst.add(bst.root, new Node(3));
        bst.add(bst.root, new Node(2));
        bst.add(bst.root, new Node(7));
        bst.add(bst.root, new Node(1));

        bst.search(bst.root, 3);
        bst.search(bst.root, 4);

        bst.inOrderTraversal(bst.root);
    }
}
