package com.sort;

import java.util.Arrays;

/**
 * Created by kecso on 2/10/17.
 */
public class BubbleSort {
    static void sort(int[] array) {
        int l = array.length;
        int tmp;

        for (int i = 0; i < l; i++) {
            boolean swap = false;
            for (int j = 1; j < l - i; j++) {
                if (array[j - 1] > array[j]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("BUBBLE SORT - O[N^2)");

        int[] arr = {12, 3, 8, 4, 2, 9, 15, 1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
