package com.graph;

import java.util.Arrays;

/**
 * Created by kecso on 3/12/17.
 */
public class IslandProblem {
    public static void main(String[] args) {
        System.out.println("Island problem");
        int[][] world = {{0, 0, -1, -1, 0, -1, 0},
                         {0, 0, 0, -1, 0, -1, 0},
                         {0, -1, 0, -1, 0, -1, 0},
                         {0, 0, -1, -1, 0, 0, 0}};

        for (int[] row: world) {
            System.out.println(Arrays.toString(row));
        }
        try {
            System.out.println(getNumberOfIslands(world));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        for(int[] row: world) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static int getNumberOfIslands(int[][] world) throws IllegalArgumentException {
        if (world == null) {
            throw new IllegalArgumentException("Input must be a 2d int array");
        }
        int numIslands = 0;
        int rows = world.length;
        int cols = world[0].length;

        // iterate though the 2d matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (world[i][j] == -1) {
                    numIslands++;
                    world[i][j] = numIslands;
                    discoverIsland(world, i, j, numIslands);
                    continue;
                } else {
                    continue;
                }

            }
        }
        return numIslands;
    }

    private static void discoverIsland(int[][] world, int i, int j, int numIslands) {
        // DFS with callstack
        int rows = world.length;
        int cols = world[0].length;
        int[][] neighbors = getNeighbors(i, j);
        for (int n = 0; n < neighbors[0].length; n++) {
            int ni = neighbors[0][n];
            int nj = neighbors[1][n];
            if (ni >= 0 && ni < rows
                    && nj >= 0 && nj < cols) {
                if (world[ni][nj] == -1) {
                    world[ni][nj] = numIslands;
                    discoverIsland(world, ni, nj, numIslands);
                } else {
                    continue;
                }
            }
        }
    }

    private static int[][] getNeighbors(int i, int j) {
        return new int[][]{{i + 1, i - 1, i, i}, {j, j, j + 1, j - 1}};
    }
}
