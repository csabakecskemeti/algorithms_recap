package com.robi1;

/**
 * Created by kecso on 2/5/17.
 */
public class Node {
    Node next;
    Node prev;
    Node special;
    Object value;
    public Node(Object value) {
        this.value = value;
        this.next = null;
        this.next = null;
        this.special = null;
    }
    public Object getValue(){
        return value;
    }
}
