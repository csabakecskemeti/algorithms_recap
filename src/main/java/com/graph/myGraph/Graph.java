package com.graph.myGraph;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by kecso on 2/25/17.
 */
public class Graph<T> {
    int size = 0;
    HashMap<T, Vertex> graph = new HashMap<T, Vertex>();

    public void addVertex(T value) {
        graph.put(value, new Vertex(value));
        size++;
    }

    public void addEdge(T src, T dst, int cost) {
        Vertex currentVertex = graph.get(src);
        Edge newEdge = new Edge(graph.get(dst), cost);
        if (currentVertex.head == null) {
            currentVertex.head = newEdge;
            currentVertex.tail = currentVertex.head;
        } else {
            currentVertex.tail.next = newEdge;
            currentVertex.tail = graph.get(src).tail.next;
        }
    }

    public void printVertices() {
        Iterator<T> iterator = graph.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    public void printEdges(T src) {
        Edge edges = graph.get(src).head;
        while(edges != null) {
            System.out.println(src + " - " + edges.cost + " - " + edges.toVertex.value);
            edges = edges.next;
        }
    }
}
