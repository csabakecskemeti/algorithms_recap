package randomTrip.tree;

/**
 * Created by kecso on 2/20/18.
 */
class Treenode {
    Treenode left;
    Treenode right;
    int val;
    public Treenode (int val) {
        this.val = val;
    }
}

public class TreeTraversals {
    public static void main(String[] args) {
        System.out.println("Tree Traversals");
        Treenode head = new Treenode(1);
        head.left = new Treenode(12);
        head.right = new Treenode(13);
        head.left.left = new Treenode(111);
        head.left.right = new Treenode(112);
        head.right.right = new Treenode(121);
        inOrder(head);
        System.out.println("================");
        levelOrder(head, 0);
        System.out.println();
        levelOrder(head, 1);
        System.out.println();
        levelOrder(head, 2);
        System.out.println();
        levelOrder(head, 3);
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
}
