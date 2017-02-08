package com.ds;

/**
 * Created by kecso on 2/7/17.
 */
public class LinkedListHomeWork1A {
    public static void main(String[] args) {
        LinkedListD<Integer> ll1 = new LinkedListD<Integer>();
        LinkedListD<Integer> ll2 = new LinkedListD<Integer>();

        ll1.add(1);
        ll1.add(5);
        ll1.add(10);
        ll1.add(15);
        ll1.add(20);

        ll2.add(5);
        ll2.add(11);
        ll2.add(12);
        ll2.add(13);
        ll2.add(14);

        while (ll1.tail != null && ll2.head != null) {
            System.out.println(ll1.popTail().value.toString());
            System.out.println(ll2.popHead().value.toString());
        }

    }
}
