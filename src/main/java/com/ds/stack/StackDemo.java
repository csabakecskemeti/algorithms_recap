package com.ds.stack;

/**
 * Created by kecso on 2/5/17.
 */
public class StackDemo {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>(5);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        System.out.println("This should be 7 - " + stack.pop());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
