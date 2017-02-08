package com.ds;

/**
 * Created by kecso on 2/3/17.
 */
public class LinkedListD<T> {
    NodeD head;

    // my addition
    NodeD tail;

    public LinkedListD() {
        head = null;
    }
    public void add(Object value) {
        NodeD newNode = new NodeD(value, null, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    // my addition
    public NodeD popHead() {
        NodeD res = head;
        head = head.next;
        if (head != null) {
            head.previous = null;
        }
        return res;
    }

    // my addition
    public NodeD popTail() {
        NodeD res = tail;
        tail = tail.previous;
        if (tail != null) {
            tail.next = null;
        }
        return res;
    }

    public void delete() {
        head = head.next;
        if (head != null) {
            head.previous = null;
        }
    }

    public void display() {
        NodeD n = head;
        while(n != null) {
            System.out.println((T)n.value);
            n = n.next;
        }
    }
}
