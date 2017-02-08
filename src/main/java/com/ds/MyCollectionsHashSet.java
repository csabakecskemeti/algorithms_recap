package com.ds;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by kecso on 2/7/17.
 */
public class MyCollectionsHashSet {
    public static void main(String[] args) {
        System.out.println("HASHSET");
        // why is HashSet ordered when I'm iterating on it?
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("h");
        hashSet.add("j");
        hashSet.add("a");
        hashSet.add("j");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n");
        Set<String> treeSet = new TreeSet<String>();
        treeSet.add("h");
        treeSet.add("j");
        treeSet.add("a");
        treeSet.add("j");
        Iterator<String> iterator2 = treeSet.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        System.out.println("\n");
        Set<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("h");
        linkedHashSet.add("j");
        linkedHashSet.add("a");
        linkedHashSet.add("j");
        Iterator<String> iterator3 = linkedHashSet.iterator();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }
    }
}
