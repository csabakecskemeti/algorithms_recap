package com;

import gnu.trove.set.hash.TLongHashSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kecso on 3/8/17.
 */
public class ForTest {

    public static void main(String[] args) {
//        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Collection<Integer> collection = null;
        System.out.println(collection.size());

        List<Integer> list = new ArrayList<>();
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);

        TLongHashSet troveHS = new TLongHashSet();
        troveHS.add(1111L);
        troveHS.add(1112L);
        troveHS.add(1113L);
        troveHS.add(1114L);
        HashSet<Long> javaUtilHS = new HashSet<>();
        javaUtilHS.add(1111L);
        javaUtilHS.add(1112L);
        javaUtilHS.add(1113L);
        javaUtilHS.add(1114L);

        List<String> stringList = new LinkedList<>();
        stringList.add("aaa");
        stringList.add("aaa");
        stringList.add("aaa");
//        stringList.add("aaa");
//        stringList.add("aaa");
//        stringList.add("aaa");
//        stringList.add("aaa");
//        stringList.add("aaa");
//        stringList.add("aaa");
//        stringList.add("aaa");
//        stringList.add("aaa");
//        stringList.add("aaa");

        Long start = System.currentTimeMillis();
        String val = "";
        for(int i = 0; i < 2000000000; i++) {
            for (int j = 0; j < array.length; j++) {
                int a = 10*j;

            }
//            TLongHashSet troveHS = new TLongHashSet();
//            troveHS.add(1111L);
//            troveHS.add(1112L);
//            troveHS.add(1113L);
//            troveHS.add(1114L);
//            troveHS.contains(1114L);
//            for(String j : stringList){
//                val = j;
//            }
//            for (int j : array) {
//                val = j;
//            }
        }

//        System.out.println("Trove hashset contains: "+(System.currentTimeMillis()-start));
//        System.out.println("internal iterator: "+(System.currentTimeMillis()-start));
        System.out.println("length: "+(System.currentTimeMillis()-start));
//        System.out.println(Arrays.toString(array));

        start = System.currentTimeMillis();
        for(int i = 0; i < 2000000000; i++) {
            for (int j = 0,  max = array.length; j < max; j++) {
                int a = 10*j;
            }
//            TLongHashSet troveHS = new TLongHashSet();
//            troveHS.add(1111L);
//            troveHS.add(1112L);
//            troveHS.add(1113L);
//            troveHS.add(1114L);
//            troveHS.remove(1114L);
//            javaUtilHS.contains(1114L);
//            for (int j = 0; j < stringList.size(); j++) {
//                val = stringList.get(j);
//            }
//            for (int j = 0; j < array.length; j++) {
//                val = array[j];
//            }
        }
//        System.out.println("Trove hashset remove: "+(System.currentTimeMillis()-start));
//        System.out.println("external iterator: "+(System.currentTimeMillis()-start));
        System.out.println("length variable: "+(System.currentTimeMillis()-start));
//        System.out.println(Arrays.toString(array));
        System.out.println(array.length);
    }
}
