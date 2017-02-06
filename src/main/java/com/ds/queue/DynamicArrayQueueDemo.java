package com.ds.queue;

/**
 * Created by kecso on 2/6/17.
 */
public class DynamicArrayQueueDemo {
    public static void main(String[] args) {
        DynamicArrayQueue<String> queue = new DynamicArrayQueue<String>(2);
        queue.queue("aaa");
        queue.queue("bbb");
        System.out.println("size: " + queue.getSize());
        queue.queue("ccc");
        System.out.println("size: " + queue.getSize());
        queue.queue("ddd");
        queue.queue("eee");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
