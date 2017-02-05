package com.robi1;

import com.sun.tools.javac.util.Pair;

/**
 * Created by kecso on 2/5/17.
 */
public class Tree2LinkedList {
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
        } else if (root.left == null && root.right == null) {
            System.out.println(root.value);
        } else if (root.left == null) {
            System.out.println(root.value);
            inOrderTraversal(root.right);
        } else if (root.right == null) {
            inOrderTraversal(root.left);
            System.out.println(root.value);
        } else {
            inOrderTraversal(root.left);
            System.out.println(root.value);
            inOrderTraversal(root.right);
        }
    }

    public static Pair<TreeNode, TreeNode> inPlaceTree2LinkedList(TreeNode root) {
        if (root == null) {
            return new Pair<TreeNode, TreeNode>(null, null);
        } else if (root.left == null && root.right == null) {
            return new Pair<TreeNode, TreeNode>(root, root);
        } else if (root.left == null) {
            TreeNode head = root;
            Pair<TreeNode, TreeNode> res = inPlaceTree2LinkedList(root.right);
            root.right = res.fst;
            res.fst.left = root;
            return new Pair<TreeNode, TreeNode>(root, res.snd);
        } else if (root.right == null) {
            Pair<TreeNode, TreeNode> res = inPlaceTree2LinkedList(root.left);
            res.snd.right = root;
            root.left = res.snd;
            return new Pair<TreeNode, TreeNode>(res.fst, root);
        } else {
            Pair<TreeNode, TreeNode> resL = inPlaceTree2LinkedList(root.left);
            resL.snd.right = root;
            root.left = resL.snd;
            Pair<TreeNode, TreeNode> resR = inPlaceTree2LinkedList(root.right);
            root.right = resR.fst;
            resR.fst.left = root;
            return new Pair<TreeNode, TreeNode>(resL.fst, resR.snd);
        }
    }
}
