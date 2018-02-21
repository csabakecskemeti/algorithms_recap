package randomTrip.tree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by kecso on 2/20/18.
 * https://www.geeksforgeeks.org/connect-nodes-at-same-level/
 */
class Treenode {
    Treenode left;
    Treenode right;
    Treenode next;
    int val;
    public Treenode (int val) {
        this.val = val;
    }
}

public class TreeTraversals {
    public static void main(String[] args) {
        System.out.println("Tree Traversals");
        Treenode head = new Treenode(1);
        head.left = new Treenode(11);
        head.right = new Treenode(12);
        head.left.left = new Treenode(111);
        head.left.right = new Treenode(112);
        head.right.right = new Treenode(113);
        head.left.left.left = new Treenode(1111);
        head.left.right.left = new Treenode(1112);
        head.left.right.right = new Treenode(1113);
        head.right.right.right = new Treenode(1114);
        System.out.println("--inordertraversal---------");
        inOrder(head);

        System.out.println("--inOrderLinker---------");
        Map<Integer, Treenode> map = new LinkedHashMap<>();
        inOrderLinker(head, 0, map);
        Treenode levelHead = map.get(3);
        System.out.print(levelHead.val);
        while(levelHead.next != null) {
            levelHead = levelHead.next;
            System.out.print( "->" + levelHead.val);
        }
        System.out.println();



        Treenode head2 = new Treenode(1);
        head2.left = new Treenode(11);
        head2.right = new Treenode(11);
        head2.left.left = new Treenode(111);
        head2.left.right = new Treenode(112);
        head2.right.right = new Treenode(121);
        head2.left.left.left = new Treenode(1111);
        head2.left.right.left = new Treenode(1112);
        head2.left.right.right = new Treenode(1113);
        head2.right.right.right = new Treenode(1114);

        System.out.println("=======levelOrder=========");
        levelOrder(head2, 0);
        System.out.println();
        levelOrder(head2, 1);
        System.out.println();
        levelOrder(head2, 2);
        System.out.println();
        levelOrder(head2, 3);
        System.out.println();
        System.out.println("-----levelOrderLinker-----");
        levelOrderLinker(head2, 3);

        Treenode levelHead2 = head2.left.left.left;
        System.out.print(levelHead2.val);
        while(levelHead2.next != null) {
            levelHead2 = levelHead2.next;
            System.out.print("->" + levelHead2.val);
        }
        System.out.println();
    }

    public static Treenode levelOrderLinker(Treenode node, int level) {
        if (node == null) {
            return null;
        }
        if (level == 0) {
            return node;
        } else {
            Treenode treenode = null;
            Treenode treenode1 = null;
            if (node.left != null) {
                treenode = levelOrderLinker(node.left, level - 1);
            }
            if (node.right != null) {
                treenode1 = levelOrderLinker(node.right, level - 1);
            }
            if (treenode != null) {
                treenode.next = treenode1;
            }
            return treenode1 == null ? treenode : treenode1;
        }
    }

    public static void levelOrder(Treenode node, int level) {
        if (node == null) {
            return;
        }
        if (level == 0) {
            System.out.print(node.val + ", ");
        } else {
            levelOrder(node.left, level - 1);
            levelOrder(node.right, level - 1);
        }
    }

    public static void inOrder(Treenode node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.println(node.val);
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    public static void inOrderLinker(Treenode node, int level, Map<Integer, Treenode> map) {
        if (node.left != null) {
            inOrderLinker(node.left, level + 1, map);
        }
        if(map.containsKey(level)) {
            Treenode treenode = map.get(level);
            while(treenode.next != null) {
                treenode = treenode.next;
            }
            treenode.next = node;
        } else {
            map.put(level, node);
        }
        //System.out.println(node.val);
        if (node.right != null) {
            inOrderLinker(node.right, level + 1, map);
        }
    }
}
