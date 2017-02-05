package com.robi1;

/**
 * Created by kecso on 2/5/17.
 */
public class LinkedListMinDemo {
    public static void main(String[] args) {
        LinkedListMin myList = new LinkedListMin();
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
        System.out.println("Min in list: " + myList.min.getValue());

        myList.removeFromHead();
        myList.removeFromHead();
        myHead = myList.head;
        while(myHead != null) {
            System.out.println(myHead.getValue());
            myHead = myHead.next;
        }
        System.out.println("Min in list: " + myList.min.getValue());
        System.out.println("2nd smallest in list: " + myList.min.special.getValue());

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
        System.out.println("Head in list: " + myList.head.getValue());
        System.out.println("Tail in list: " + myList.tail.getValue());
        System.out.println("Min in list: " + myList.min.getValue());

        System.out.println("\nRemove all");
        myList.removeFromHead();
        System.out.println("Head in list: " + myList.head);
        System.out.println("Tail in list: " + myList.tail);
        System.out.println("Min in list: " + myList.min);
    }
}
