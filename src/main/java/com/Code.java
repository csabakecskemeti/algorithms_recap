package com;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kecso on 2/16/17.
 */
public class Code {

    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Hello Java");
        Bla bla = new Bla(8);
        System.out.println(bla.i);


        Queue<Integer> queue = new LinkedList<Integer>();
        queue.iterator();

        throw new IllegalArgumentException("msg");

    }


}

class Bla{

    public int i;
    public Bla(int i) {
        this.i = i;
    }
}

