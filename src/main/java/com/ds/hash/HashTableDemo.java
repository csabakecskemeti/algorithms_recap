package com.ds.hash;

/**
 * Created by kecso on 2/5/17.
 */
public class HashTableDemo {

    public static void main (String[] args) {
        HashTable<String> hashTable = new HashTable<String>(10);
        hashTable.put(11, "aaa");
        hashTable.put(121, "bbb");
        hashTable.put(14, "ccc");
        hashTable.put(45, "ddd");
        hashTable.put(66, "eee");

        System.out.println(hashTable.get(11));
    }
}
