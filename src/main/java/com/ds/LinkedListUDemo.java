package com.ds;

/**
 * Created by kecso on 2/3/17.
 */
public class LinkedListUDemo {
    public  static void main(String[] args) {
        LinkedListU<String> myList = new LinkedListU<String>();
        myList.add("me");
        myList.add("he");
        myList.add("she");
        myList.display();
        System.out.println("\nAfter delete: \n");
        myList.delete();
        myList.display();
    }
}
