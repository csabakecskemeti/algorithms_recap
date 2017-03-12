package com.ds;

import com.ds.hash.HashTable;

/**
 * Created by kecso on 2/7/17.
 */
public class HashHomeWork2 {
    public static void main(String[] args) {
        int[] array = {0, 0, 0, 1, 8, 5, 0, 0, 2};
        HashTable<Integer> hashTable = new HashTable<Integer>(4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                hashTable.put(i, array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
//            System.out.println(hashTable.get(i) != null? hashTable.get(i): 0);
        }
    }
}
