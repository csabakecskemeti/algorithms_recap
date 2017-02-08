package com.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kecso on 2/7/17.
 */
public class MyCollectionsHashMap {
    public static void main(String[] args) {
        System.out.println("HASHMAP");
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "aaa");
        hashMap.put(22, "bbb");

        System.out.println(hashMap.get(22));

        System.out.println("\n");
        for(Map.Entry e: hashMap.entrySet()) {
            System.out.println(e.getKey() + " - " + e.getValue());
        }

        hashMap.put(22, "bbb2");
        System.out.println(hashMap.get(22));
        hashMap.remove(22);
    }
}
