package com.ds.stack;

/**
 * Created by kecso on 2/5/17.
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack<Integer> dynamicStack = new LinkedListStack<Integer>();
        dynamicStack.push(3);
        dynamicStack.push(4);
        dynamicStack.push(5);
        dynamicStack.push(6);
        dynamicStack.push(7);
        dynamicStack.push(8);
        System.out.println("This should be 8 - " + dynamicStack.pop());
        dynamicStack.pop();
        dynamicStack.pop();
        dynamicStack.pop();
        dynamicStack.pop();
        dynamicStack.pop();
        dynamicStack.pop();
    }
}
