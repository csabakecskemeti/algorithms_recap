package com.graph.myGraph;

/**
 * Created by kecso on 2/25/17.
 */
public class Edge implements Comparable{
    Vertex toVertex;
    int cost;
    Edge next;
    public Edge(Vertex toVertex, int cost) {
        this.toVertex = toVertex;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return cost == edge.cost;
    }

    public int compareTo(Object o) {
        if (this.cost > ((Edge)o).cost) {
            return 1;
        } else if (this.cost < ((Edge)o).cost){
            return -1;
        }
        return 0;
    }

}
