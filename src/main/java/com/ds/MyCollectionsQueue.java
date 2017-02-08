package com.ds;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by kecso on 2/8/17.
 */
public class MyCollectionsQueue {
    public static void main(String[] args) {
        System.out.println("QUEUE");
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(19);
        queue.add(13);
        queue.add(12);
        queue.add(15);
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println("PRIORITY QUEUE");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.add(19);
        priorityQueue.add(13);
        priorityQueue.add(12);
        priorityQueue.add(15);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll().toString());


        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<Student>();
        studentPriorityQueue.add(new Student("ccc", 13));
        studentPriorityQueue.add(new Student("aaa", 3));
        studentPriorityQueue.add(new Student("ddd", 1));
        studentPriorityQueue.add(new Student("bbb", 11));
        System.out.println(studentPriorityQueue.poll());
        System.out.println(studentPriorityQueue.poll());
    }
}
