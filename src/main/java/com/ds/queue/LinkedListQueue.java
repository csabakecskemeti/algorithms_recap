package com.ds.queue;

import com.ds.NodeD;

/**
 * Created by kecso on 2/6/17.
 */
public class LinkedListQueue<T> {
    NodeD rear;
    NodeD front;
    public LinkedListQueue() {
        rear = null;
        front = null;
    }
    public void queue(Object value) {
        NodeD newNode = new NodeD(value, null, null);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = null;
            newNode.previous = rear;
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T dequeue() {
        if (front == null || rear == null) {
            System.out.println("Queue is empty");
            return null;
        } else {
            if (front.next != null) {
                front.next.previous = null;
            }
            Object res = front.value;
            front = front.next;
            return (T) res;
        }
    }

}
