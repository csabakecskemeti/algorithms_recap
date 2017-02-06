package com.ds.queue;

/**
 * Created by kecso on 2/6/17.
 */
public class ArrayQueue<T> {
    Object[] array;
    int rear;
    int front;
    int size;
    public ArrayQueue(int size) {
        this.size = size;
        array = new Object[size];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return (rear == size - 1);
    }

    public boolean isEmpty() {
        return (front == -1 || front > rear);
    }

    public void queue(Object newItem) {
        if (isFull()) {
            System.out.println("Queue is full, can't add");
        } else {
            rear++;
            array[rear] = newItem;
            if (front == -1) {
                front = 0;
            }
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
}
