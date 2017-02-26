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
        Edge newEdge = new Edge(currentVertex, graph.get(dst), cost);
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
        HashMap<Character, Edge> shortestPathToVertex = new HashMap<Character, Edge>();
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();

        // setup
        Edge startEdge = new Edge(graph.get(src), graph.get(src), 0);
        queue.add(startEdge);
        shortestPathToVertex.put((Character) startEdge.fromVertex.value, startEdge);
        int distance2Destination = -1;
        int iteration = 0;
        while(!queue.isEmpty()) {
            Edge current = queue.poll();
            int distance = current.cost;
            // scan edges
            Edge edge = current.toVertex.head;
            while(edge != null){
                iteration++;
                Character neighborValue = (Character) edge.toVertex.value;
                int neighborCost = edge.cost + distance;
                if(neighborValue == dst) {
                    distance2Destination = neighborCost;
                }
                Edge currentEdge = new Edge(edge.fromVertex, edge.toVertex, neighborCost);

                // to keep track of path and enqueue path if it's better than before
                if(!shortestPathToVertex.containsKey(edge.toVertex.value)
                        || shortestPathToVertex.get(edge.toVertex.value).cost > neighborCost) {
                    shortestPathToVertex.put((Character) edge.toVertex.value, currentEdge);
                    queue.add(currentEdge);
                }
                edge = edge.next;
            }
            if (queue.isEmpty()) {
                System.out.println("\nDestination unreachable: " + src + " X " + dst);
                return;
            }
            if (distance2Destination <= queue.peek().cost && distance2Destination > 0) {
                System.out.println("\nDestination " + dst + " found in: " + distance2Destination + " from " + src);

                // display path
                int cost = shortestPathToVertex.get((Character)dst).cost;
                Character v = (Character) dst;
                while(true) {
                    System.out.print(v + " <- " + cost + " <- ");
                    cost = shortestPathToVertex.get(shortestPathToVertex.get(v).fromVertex.value).cost;
                    v = (Character)shortestPathToVertex.get(v).fromVertex.value;
                    if ((Character)src == v) {
                        System.out.println(v);
                        System.out.println("Iteration steps: " + iteration);
                        return;
                    }
                }
            }
        }
    }
}
