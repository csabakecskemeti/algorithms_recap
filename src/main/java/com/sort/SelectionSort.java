package com.sort;

import java.util.Arrays;

/**
 * Created by kecso on 2/10/17.
 */
public class SelectionSort {
    static void sort(int[] array) {
        int l = array.length;
        int tmp;

        for (int i = 0; i < l - 1; i++) {
            int min = i;
            for (int j = i + 1; j < l; j++) {
                if (array[j] < array[i]) {
                    // update min index 
                    min = j;
                }
            }
            if (min != i) {
                tmp = array[min];
                array[min] = array[i];
                array[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("SELECT SORT - O[N^2)");

        int[] arr = {12, 3, 8, 4, 2, 9, 15, 1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
