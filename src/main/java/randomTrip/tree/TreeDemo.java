package randomTrip.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kecso on 10/15/17.
 */
public class TreeDemo {
    public static void main(String[] args) {
        System.out .println("Examples with Tree");
        int[] array = {0,1,2,3,4,5,6,7,8,9,10};
        TreeNode head = new TreeNode(array[0]);
        array2tree(head, 0, array);
        inOrderTraversal(head);
    }

    public static void array2tree(TreeNode current, int index, int[] array) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        if (leftIndex < array.length) {
            current.left = new TreeNode(array[leftIndex]);
            array2tree(current.left, leftIndex, array);
        }
        if (rightIndex < array.length) {
            current.right = new TreeNode(array[rightIndex]);
            array2tree(current.right, rightIndex, array);
        }
    }

    public static void inOrderTraversal(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            int i = queue.size();
            Queue<TreeNode> printQueue = new LinkedList<>();
            while (i > 0) {
                printQueue.add(queue.poll());
                i--;
            }
            while (!printQueue.isEmpty()) {
                TreeNode current = printQueue.poll();
                if (current != null) {
                    System.out.print(current.value + "   ");
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }
            System.out.println();
        }

    }
}

class TreeNode{
    public TreeNode left;
    public TreeNode right;
    public int value;

    public TreeNode(int value) {
        this.value = value;
    }
}
