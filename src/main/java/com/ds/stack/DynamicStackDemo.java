package com.ds.stack;

/**
 * Created by kecso on 2/5/17.
 */
public class DynamicStackDemo {
    public static void main(String[] args) {
        DynamicStack<Integer> dynamicStack = new DynamicStack<Integer>(2);
        System.out.println(dynamicStack.getSize());
        dynamicStack.push(3);
        dynamicStack.push(4);
        dynamicStack.push(5);
        dynamicStack.push(6);
        dynamicStack.push(7);
        dynamicStack.push(8);
        System.out.println(dynamicStack.getSize());
        System.out.println("This should be 8 - " + dynamicStack.pop());
        dynamicStack.pop();
        dynamicStack.pop();
        dynamicStack.pop();
        dynamicStack.pop();
        dynamicStack.pop();
        dynamicStack.pop();
    }
}
