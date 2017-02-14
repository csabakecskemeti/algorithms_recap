package com.graph;

import java.util.Stack;

/**
 * Created by kecso on 2/13/17.
 */
public class DFS {
    int size;
    ADJList[] array;
    public DFS(int size){
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

    public void DFSExplore(int startVertex) {
        Boolean[] visited = new Boolean[size];
        for (int i = 0; i < size; i++) {
            visited[i] = false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(startVertex);

        while(!stack.empty()) {
            int n = stack.pop();
            stack.push(n);
            visited[n] = true;
            Node head = array[n].head;
            Boolean isDone = true;
            while (head != null) {
//                System.out.println("add "+ head.value);
                if (!visited[head.value]){
                    stack.push(head.value);
                    visited[head.value] = true;
                    isDone = false;
                    break;
                }
                else {
                    head = head.next;
                }
            }
            if (isDone) {
                int out = stack.pop();
                System.out.println("Visit node: " + out);
            }
        }
    }
}
