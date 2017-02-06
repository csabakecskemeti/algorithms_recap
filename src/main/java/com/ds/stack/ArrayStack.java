package com.ds.stack;

/**
 * Created by kecso on 2/5/17.
 */
public class ArrayStack<T> {
    Object[] arrayStack;
    int size;
    int top;
    public ArrayStack(int size) {
        this.size = size;
        arrayStack = new Object[size];
        top = -1;
    }

    public void push(Object item) {
        if (isFull()) {
            System.out.println("Stack is full, can't add more");
        } else {
            top++;
            arrayStack[top] = item;
        }
    }

    public Object pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        } else {
            top--;
            return arrayStack[top + 1];
        }
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        }
        return false;
    }

}
