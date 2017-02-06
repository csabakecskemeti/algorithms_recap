package com.ds.queue;

/**
 * Created by kecso on 2/6/17.
 */
public class LinkedListQueueDemo {
    public static void main(String[] args) {
        LinkedListQueue<String> queue = new LinkedListQueue<String>();
        queue.queue("aaa");
        queue.queue("bbb");
        queue.queue("ccc");
        queue.queue("ddd");
        queue.queue("eee");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
