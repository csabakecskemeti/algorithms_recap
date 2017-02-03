package com.ds;

/**
 * Created by kecso on 2/3/17.
 */
public class LinkedListU<T> {
    Node head;
    public LinkedListU() {
        head = null;
    }
    public void add(Object value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            this.head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    public void delete() {
        head = head.next;
    }
    public void display() {
        Node n = head;
        while(n != null) {
            System.out.println((T)n.value);
            n = n.next;
        }
    }
}
