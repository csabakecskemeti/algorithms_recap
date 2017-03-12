package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kecso on 3/8/17.
 */
public class ForTest {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = new ArrayList<>();
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


        Long start = System.currentTimeMillis();
        int val = 0;
        for(int i = 0; i < 200000000; i++) {
            for(Integer j : list){
                val = j;
            }
//            for (int j : array) {
//                val = j;
//            }
        }

        System.out.println("internal iterator: "+(System.currentTimeMillis()-start));
        System.out.println(Arrays.toString(array));

        start = System.currentTimeMillis();
        for(int i = 0; i < 200000000; i++) {
            for (int j = 0; j < list.size(); j++) {
                val = list.get(j);
            }
//            for (int j = 0; j < array.length; j++) {
//                val = array[j];
//            }
        }
        System.out.println("external iterator: "+(System.currentTimeMillis()-start));
        System.out.println(Arrays.toString(array));
    }
}
