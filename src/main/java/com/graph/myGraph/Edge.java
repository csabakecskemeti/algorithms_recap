package com.graph.myGraph;

/**
 * Created by kecso on 2/25/17.
 */
public class Edge {
    Vertex toVertex;
    int cost;
    Edge next;
    public Edge(Vertex toVertex, int cost) {
        this.toVertex = toVertex;
        this.cost = cost;
    }
}
