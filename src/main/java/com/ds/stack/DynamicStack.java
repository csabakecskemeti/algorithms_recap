package com.ds.stack;

import java.util.Arrays;

/**
 * Created by kecso on 2/5/17.
 */
public class DynamicStack<T> {
    Object[] arrayStack;
    int size;
    int top;
    public DynamicStack(int size) {
        this.size = size;
        arrayStack = new Object[size];
        top = -1;
    }

    public int getSize() {
        return arrayStack.length;
    }
    public void push(Object item) {
        ensureCapacicty(top+2);
        top++;
        arrayStack[top] = item;
    }

    public void ensureCapacicty(int minCapacity) {
        int oldCapacity = getSize();
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            // why is this if?
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            arrayStack = Arrays.copyOf(arrayStack, newCapacity);
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
}
