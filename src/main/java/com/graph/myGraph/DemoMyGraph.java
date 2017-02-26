package com.graph.myGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kecso on 2/25/17.
 */
public class DemoMyGraph {
    public static void main(String args[]) {
        System.out.println("MY GRAPH DEMO");

        Graph<Character> g = new Graph<Character>();
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('X');

        g.printVertices();

        g.addEdge('A', 'B', 10);
        g.addEdge('A', 'C', 10);
        g.addEdge('A', 'E', 100);
        g.addEdge('B', 'D', 5);
        g.addEdge('D', 'E', 30);

        g.printEdges('A');
        g.printEdges('B');
        g.printEdges('C');
        g.printEdges('D');
        g.printEdges('E');

        Queue<Integer> queue = new LinkedList<Integer>();
    }
}
