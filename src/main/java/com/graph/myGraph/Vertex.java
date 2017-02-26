package com.graph.myGraph;

/**
 * Created by kecso on 2/25/17.
 */
public class Vertex {
    Object value;
    Edge head;
    Edge tail;
    public Vertex(Object value){
        this.value = value;
    }
}
