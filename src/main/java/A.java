/**
 * Created by kecso on 3/31/17.
 */

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class A
{
    public static void yahoo(int kingX, int kingY, int Ex, int Ey){
        Queue<Node> q = new LinkedList<>();
        Node King = new Node(kingX,kingY);
        HashSet<Node> visited = new HashSet<>();
        q.offer(King);
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Node node = q.poll();
                if(node.x == Ex && node.y == Ey){
                    System.out.println(res);
                }
                visited.add(node);
                node.n();
                for(int i = 0; i < 8; i++){
                    q.offer(node.neighbor[i]);
                }
            }
            res++;
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        yahoo(3,3,5,5);

    }
}


class Node{
    int x;
    int y;
    int[] xAxis = new int[]{1,1,1,0,0,-1,-1,-1};
    int[] yAxis = new int[]{0,1,-1,1,-1,1,0,-1};
    public Node[] neighbor = new Node[8];
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void n() {
        for(int i = 0; i < 8; i++){
            neighbor[i] = new Node(x + xAxis[i], y + yAxis[i]);
        }
    }
}
