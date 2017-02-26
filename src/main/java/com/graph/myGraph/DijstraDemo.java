package com.graph.myGraph;

/**
 * Created by kecso on 2/26/17.
 */
public class DijstraDemo {
    public static void main(String[] args) {
        System.out.println("DIJSTRA DEMO");
        // setup grapth
        Graph<Character> graph = new Graph<Character>();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addEdge('A', 'B', 10);
        graph.addEdge('A', 'C', 30);
        graph.addEdge('A', 'D', 5);
        graph.addEdge('B', 'E', 50);
        graph.addEdge('C', 'E', 5);
        graph.addEdge('C', 'F', 5);
        graph.addEdge('F', 'C', 5);
        graph.addEdge('F', 'G', 5);
        graph.addEdge('D', 'G', 10);
        graph.addEdge('G', 'F', 5);
        graph.addEdge('E', 'H', 1);
        graph.addEdge('G', 'H', 60);

//        graph.printVertices();
//        graph.printEdges('F');

        graph.dijstra('A', 'H');
        graph.dijstra('A', 'F');
        graph.dijstra('B', 'F');
        graph.dijstra('B', 'H');
    }
}
