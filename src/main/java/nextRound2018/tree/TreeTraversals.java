package nextRound2018.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversals {
    public static void main(String[] args) {
        System.out.println("Tree traversals");
        TreeNode head = new TreeNode(6);
        createTree(head);
        System.out.println("IN ORDER");
        inOrder(head);
        System.out.println("\nLEVEL ORDER");
        levelOrder(head);
    }
    
    private static void levelOrder(TreeNode head) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(head);
        int qs = levelQueue.size();
        while (!levelQueue.isEmpty()) {
            for (int i = 0; i < qs; i++) {
                TreeNode curr = ((LinkedList<TreeNode>) levelQueue).pop();
                System.out.print(curr.value + ",");
                if (curr.left != null) {
                    levelQueue.add(curr.left);
                }
                if (curr.right != null) {
                    levelQueue.add(curr.right);
                }
                if (i == qs - 1) {
                    System.out.println("\n---------");
                    qs += levelQueue.size();
                }
            }
        }
    }
    
    private static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }
    
    private static void createTree(TreeNode head) {
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(4);
        head.right.left = new TreeNode(7);
        head.right.right = new TreeNode(9);
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;
    public TreeNode(int value) {
        this.value = value;
    }
}
