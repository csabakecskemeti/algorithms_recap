package randomTrip;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by kecso on 2/18/18.
 */

public class BFS {
    public static void main(String[] args) {
        System.out.println("BFS demo");
        char[][] maze = {
                {'x','*','x','x'},
                {'S','*','*','x'},
                {'x','*','x','E'},
                {'x','*','*','*'}
        };
        int[] start = {1,0};
        bfs(maze, start);
    }

    public static int[][] bfs(char[][] maze, int[] start) {
        if (maze == null || start == null) {
            return null;
        }
        int[] xn = {0, 0, 1, -1};
        int[] yn = {-1, 1, 0, 0};
        int distance = 0;
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new ImmutablePair<>(start[0], start[1]));
        int queueSize = queue.size();
        while (queueSize > 0) {
            Pair curr = queue.poll();
            visited.add(curr);
            queueSize--;
            if (queueSize == 0) {
                distance++;
            }
            if (maze[(int)curr.getLeft()][(int)curr.getRight()] == 'E') {
                System.out.println("found in " + distance);
                return null;
            } else {
                for (int i = 0; i < 4; i++) {
                    int nx = (int)curr.getLeft() + xn[i];
                    int ny = (int)curr.getRight() + yn[i];
                    if (nx >= 0 && ny >= 0
                            && nx < maze.length
                            && ny < maze[0].length
                            && maze[nx][ny] != 'x') {

                        Pair<Integer, Integer> n = new ImmutablePair<>(nx, ny);
                        if (!visited.contains(n)) {
                            System.out.println(nx + " " + ny + " " + maze[nx][ny]);
                            queue.add(n);
                        }
                    }
                }

                queueSize = queue.size();
                System.out.println(queueSize + "   " + distance);

            }
        }
        return null;
    }
}
