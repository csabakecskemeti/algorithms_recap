package com.ds;

/**
 * Created by kecso on 2/3/17.
 */
public class NodeD {
    public Object value;
    public NodeD next;
    public NodeD previous;
    public NodeD(Object value, NodeD next, NodeD previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
}
