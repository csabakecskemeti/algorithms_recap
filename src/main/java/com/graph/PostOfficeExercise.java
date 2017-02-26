package com.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kecso on 2/25/17.
 */
public class PostOfficeExercise {
    // define the coordinate for post offices
    static class coordinate {
        int i;
        int j;

        public coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public coordinate[] getNeighbors() {
            coordinate[] neighbors = new coordinate[4];
            neighbors[0] = new coordinate(i - 1, j);
            neighbors[1] = new coordinate(i + 1, j);
            neighbors[2] = new coordinate(i, j - 1);
            neighbors[3] = new coordinate(i, j + 1);
            return neighbors;
        }
    }

    public static void main(String[] args) {
        // Test case
        coordinate[] PostOfficeLocations = {
                new coordinate(3, 1),
                new coordinate(2, 3),
                new coordinate(4, 4)
        };
        FindShortPath(PostOfficeLocations);
    }

    public static void FindShortPath(coordinate[] PostOffice) {
        System.out.println("BFS - sortest path to post office");
        int[][] result = new int[6][6];
        HashSet<String> visited = new HashSet<String>();
        Queue<coordinate> queue = new LinkedList<coordinate>();
        // initialize queue
        for (int i = 0; i < PostOffice.length; i++) {
            queue.add(PostOffice[i]);
        }
        int distance = 0;
        Queue<coordinate> tmpQueue = new LinkedList<coordinate>();
        while (!queue.isEmpty()) {
            coordinate item = queue.poll();
            if (!visited.contains(item.i + "," + item.j)){
                visited.add(item.i + "," + item.j);
                result[item.i][item.j] = distance;
                coordinate[] neighbors = item.getNeighbors();
                for (int i = 0; i < neighbors.length; i++) {
                    if (!visited.contains(neighbors[i].i + "," + neighbors[i].j)
                            && neighbors[i].i < 6
                            && neighbors[i].i >= 0
                            && neighbors[i].j < 6
                            && neighbors[i].j >= 0) {
                        tmpQueue.add(neighbors[i]);
                    }
                }
            }
            if (queue.isEmpty()) {
                while (!tmpQueue.isEmpty()) {
                    queue.add(tmpQueue.poll());
                }
                distance++;
            }
        }
        for (int i = result.length - 1; i >=0;  i--) {
            System.out.println(i + Arrays.toString(result[i]));
        }
        System.out.println("  0  1  3  4  5  6");

        /// TODO: write your code here
        /// TODO:Print 2D array as it show in the images question
    }


}
