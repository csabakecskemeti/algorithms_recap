package com.ds.stack;

import com.ds.Node;

/**
 * Created by kecso on 2/5/17.
 */
public class LinkedListStack<T> {
    Node top;
    public LinkedListStack() {
        top = null;
    }
    public void push(Object value) {
        Node newNode = new Node(value, null);
        if (top == null) {
            this.top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }
    public Object pop() {
        if(top == null) {
            System.out.println("Stack is empty");
            return null;
        }
        T value = (T)top.value;
        top = top.next;
        return value;
    }

}
