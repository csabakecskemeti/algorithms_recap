package com.ds;

import com.ds.stack.LinkedListStack;

/**
 * Created by kecso on 2/7/17.
 */
public class LinkedListHomeWork1B {
    public static void main(String[] args) {
        LinkedListU<Integer> ll1 = new LinkedListU<Integer>();
        LinkedListU<Integer> ll2 = new LinkedListU<Integer>();

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

        LinkedListStack<Integer> rewll1 = new LinkedListStack<Integer>();
        Node ll1Head = ll1.head;
        while (ll1Head != null) {
            rewll1.push(ll1Head.value);
            ll1Head = ll1Head.next;
        }

        Node ll2Head = ll2.head;
        while (rewll1.top != null && ll2Head != null) {
            System.out.println(rewll1.pop());
            System.out.println(ll2Head.value);
            ll2Head = ll2Head.next;
        }


    }
}
