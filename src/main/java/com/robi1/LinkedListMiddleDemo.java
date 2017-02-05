package com.robi1;

/**
 * Created by kecso on 2/5/17.
 */
public class LinkedListMiddleDemo {
    public static void main(String[] args) {
        LinkedListMiddle myList = new LinkedListMiddle();
        myList.add(5);
        myList.add(9);
        myList.add(4);
        myList.add(7);
        myList.add(3);
        myList.add(18);

        Node myHead = myList.head;
        while(myHead != null) {
            System.out.println(myHead.getValue());
            myHead = myHead.next;
        }
        System.out.println("Middle of the list: " + myList.middle.getValue());

        myList.removeFromHead();
        myHead = myList.head;
        while(myHead != null) {
            System.out.println(myHead.getValue());
            myHead = myHead.next;
        }
        System.out.println("Middle of the list: " + myList.middle.getValue());

        System.out.println("\nReverse iter:");
        Node myTail = myList.tail;
        while(myTail != null) {
            System.out.println(myTail.getValue());
            myTail = myTail.prev;
        }

        System.out.println("\nRemove all but one");
        myList.removeFromHead();
        myList.removeFromHead();
        myList.removeFromHead();
        myList.removeFromHead();
        System.out.println("Head in list: " + myList.head.getValue());
        System.out.println("Tail in list: " + myList.tail.getValue());
        System.out.println("Middle of the list: " + myList.middle.getValue());

        System.out.println("\nRemove all");
        myList.removeFromHead();
        System.out.println("Head in list: " + myList.head);
        System.out.println("Tail in list: " + myList.tail);
        System.out.println("Middle of the list: " + myList.middle);
    }
}
