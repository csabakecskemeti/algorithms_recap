package randomTrip.tree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by kecso on 2/20/18.
 * https://www.geeksforgeeks.org/connect-nodes-at-same-level/
 */
class Treenode {
    Treenode left;
    Treenode right;
    Treenode next;
    Treenode levelHead;
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
        Treenode levelHead = map.get(3).levelHead;
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
        int h2height = treeHeight(head2);
        System.out.println("height: " + h2height);
        for(int i = 0; i < h2height; i++) {
            levelOrder(head2, i);
            System.out.println();
        }
        System.out.println("=======levelOrderBFS=========");
        levelOrderBFS(head2);

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

    public static void levelOrderBFS(Treenode node) {
        Queue<Treenode> queue = new LinkedList<>();
        queue.add(node);
        int s = queue.size();
        while(s > 0) {
            Treenode curr = queue.poll();
            System.out.println(curr.val);
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
            s--;
            if (s == 0) {
                System.out.println("---- next level ----");
                s = queue.size();
            }
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
            // this is just needed to be able to get the levelHead from the map >>
            if (treenode.levelHead == null) {
                node.levelHead = treenode;
            } else {
                node.levelHead = treenode.levelHead;
            }
            // <<
            treenode.next = node;
        }
        map.put(level, node);
        if (node.right != null) {
            inOrderLinker(node.right, level + 1, map);
        }
    }

    public static int treeHeight(Treenode node) {
        if (node == null) {
            return 0;
        }
        int lh = treeHeight(node.left);
        int rh = treeHeight(node.right);
        return lh > rh ? lh + 1 : rh + 1;
    }
}
