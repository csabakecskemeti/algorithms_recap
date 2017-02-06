package com.ds.queue;

import java.util.Arrays;

/**
 * Created by kecso on 2/6/17.
 */
public class DynamicArrayQueue<T> {
    Object[] array;
    int rear;
    int front;
    int size;
    public DynamicArrayQueue(int size) {
        this.size = size;
        array = new Object[size];
        front = -1;
        rear = -1;
    }

    public int getSize() {
        return array.length;
    }

    public boolean isFull() {
        return (rear == size - 1);
    }

    public boolean isEmpty() {
        return (front == -1 || front > rear);
    }

    public void queue(Object newItem) {
        ensureCapacicty(rear + 2);
        rear++;
        array[rear] = newItem;
        if (front == -1) {
            front = 0;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        T res = (T) array[front];
        front++;
        return res;
    }

    public void ensureCapacicty(int minCapacity) {
        int oldCapacity = array.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            // why is this if?
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            array = Arrays.copyOf(array, newCapacity);
        }
    }
}
