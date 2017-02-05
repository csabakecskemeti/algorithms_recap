package com.robi1;

/**
 * Created by kecso on 2/5/17.
 */
public class LinkedListMin {
    Node head;
    Node tail;
    Node min;
    public LinkedListMin() {
        head = null;
        tail = null;
        min = null;
    }

    public void add(Integer value) {
        if (head == null && tail == null && min == null) {
            Node node = new Node(value);
            head = node;
            tail = node;
            min = node;
        } else {
            Node node = new Node(value);
            head.prev = node;
            node.next = head;
            head = node;
            head.special = min;
            if((Integer)head.next.getValue() >= (Integer)head.getValue()) {
                min = head;
            }
        }
    }

    public void removeFromHead() {
        if (head.next != null) {
            min = head.special;
            head.next.prev = null;
            Node oldHead = head;
            head = head.next;
            oldHead.next = null;
        } else {
            head = null;
            tail = null;
            min = null;
        }
    }
}
