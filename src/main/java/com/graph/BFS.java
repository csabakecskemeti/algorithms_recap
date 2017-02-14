package com.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kecso on 2/13/17.
 */
public class BFS {
    int size;
    ADJList[] array;
    public BFS(int size){
        this.size = size;
        array = new ADJList[this.size];
        for(int i = 0; i < size; i++) {
            array[i] = new ADJList();
            // this is not required
//            array[i].head = null;
        }
    }

    public void add(int src, int dst) {
        Node node = new Node(dst, null);
        node.next = array[src].head;
        array[src].head = node;
    }

    public void BFSExplore(int startVertex) {
        Boolean[] visited = new Boolean[size];
        for (int i = 0; i < size; i++) {
            visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startVertex);

        while(!queue.isEmpty()) {
            int n = queue.poll();
            visited[n] = true;
            System.out.println("Visit node: " + n);
            Node head = array[n].head;
            while (head != null) {
//                System.out.println("add "+ head.value);
                if (!visited[head.value]){
                    queue.add(head.value);
                    visited[head.value] = true;
                }
                head = head.next;
            }
        }
    }
}
