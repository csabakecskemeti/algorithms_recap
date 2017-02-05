package com.robi1;

/**
 * Created by kecso on 2/5/17.
 */
public class TreeNode {
    TreeNode left;
    TreeNode right;
    Object value;

    public TreeNode(Object value) {
        this.value =  value;
        this.left = null;
        this.right = null;
    }

    public Object getValue() {
        return this.value;
    }
}
