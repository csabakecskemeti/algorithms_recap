package com.ds;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by kecso on 2/7/17.
 */
public class MyCollectionsLinkedList {
    public static void main(String[] args) {
        System.out.println("LINKED LIST");
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("aaa");
        linkedList.add("bbb");
        linkedList.add("bbb");
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
