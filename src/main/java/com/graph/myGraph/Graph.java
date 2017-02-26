package com.graph.myGraph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

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

    public void dijstra(T src, T dst) {
        // TODO: display path
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        queue.add(new Edge(graph.get(src), 0));
        int distance2Destination = -1;
        while(!queue.isEmpty()) {
            Edge current = queue.poll();
            int distance = current.cost;
            // scan edges
            Edge neighbor = current.toVertex.head;
            while(neighbor != null){
//                System.out.println(distance2Destination);
                Character neighborValue = (Character) neighbor.toVertex.value;
                int neighborCost = neighbor.cost;
                if(neighborValue == (Character) dst) {
//                    System.out.println("curr: " + current.toVertex.value
//                            + " distance " + distance + " nc " + neighborCost);
                    distance2Destination = distance + neighborCost;
                }
//                System.out.println("curr: " + current.toVertex.value
//                        + " distance " + distance + " to nb " + neighborValue + " nc " + neighborCost);
                queue.add(new Edge(graph.get(neighborValue), distance + neighborCost));
                neighbor = neighbor.next;
            }
            if (queue.isEmpty()) {
                System.out.println("Destination unreachable");
                return;
            }
            if (distance2Destination <= queue.peek().cost && distance2Destination > 0) {
                System.out.println("Destination found in: " + distance2Destination);
                return;
            }
        }
    }
}
