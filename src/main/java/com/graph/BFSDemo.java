package com.graph;

/**
 * Created by kecso on 2/13/17.
 */
public class BFSDemo {
    public static void main(String[] args) {
        System.out.println("BFS DEMO");
        BFS graph = new BFS(6);
        graph.add(0,2);
        graph.add(0,1);
        graph.add(1,4);
        graph.add(1,3);
        graph.add(1,0);
        graph.add(3,1);
        graph.add(4,1);
        graph.add(2,5);
        graph.add(2,1);
        graph.add(5,2);

        graph.BFSExplore(0);
    }
}
