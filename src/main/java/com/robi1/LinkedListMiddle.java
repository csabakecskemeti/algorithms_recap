package com.robi1;

/**
 * Created by kecso on 2/5/17.
 */
public class LinkedListMiddle {
    Node head;
    Node tail;
    Node middle;
    int size;

    public void LinkedListMiddle() {
        head = null;
        tail = null;
        middle = null;
        size = 0;
    }

    public void add(Integer value) {
        size++;
        if(head == null && tail == null && middle == null) {
            Node node = new Node(value);
            head = node;
            tail = node;
            middle = node;
        } else {
            Node node = new Node(value);
            node.next = head;
            head.prev = node;
            head = node;
            if (size%2 != 0) {
                middle = middle.prev;
            }
        }
    }

    public void removeFromHead() {
        size--;
        if(head != null) {
            head.next.prev = null;
            Node oldHead = head;
            head = head.next;
            oldHead.next = null;
            if(size%2 == 0) {
                middle = middle.next;
            }
        } else {
            head = null;
            tail = null;
            middle = null;
            size = 0;
        }
    }
}
