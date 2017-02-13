package com.sort;

import java.util.Arrays;

/**
 * Created by kecso on 2/12/17.
 */
public class HeapSort {
    static int total;

    static void swap(Comparable[] array, int a, int b) {
        Comparable tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    static void heapify(Comparable[] array, int parent) {
        int left = parent * 2;
        int right = left + 1;
        int greatest = parent;
        if (left <= total && array[left].compareTo(array[greatest]) >= 0) {
            greatest = left;
        }
        if (right <= total && array[right].compareTo(array[greatest]) >= 0) {
            greatest = right;
        }
        if (greatest != parent) {
            swap(array, parent, greatest);
            heapify(array, greatest);
        }
    }

    static void sort(Comparable[] array) {
        total = array.length - 1;
        for (int i = total/2; i >= 0; i--) {
            heapify(array, i);
        }
        for (int i = total; i > 0; i--) {
            swap(array, 0, i);
            total--;
            heapify(array, 0);
        }
    }
    public static void main(String[] args) {
        System.out.println("HEAP SORT - O[NlogN), space O(N)");

        Integer[] arr = {12, 3, 8, 4, 2, 9, 15, 1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
