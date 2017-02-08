package com.ds;

import java.util.Stack;

/**
 * Created by kecso on 2/8/17.
 */
public class MyCollectionsStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("admin");
        stack.push("manager");
        stack.push("tester");

        System.out.println(stack.pop());
    }
}
