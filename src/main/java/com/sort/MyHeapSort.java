package com.sort;

import java.util.Arrays;

/**
 * Created by kecso on 2/12/17.
 */
public class MyHeapSort {
    static int total;

    static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    static void heapify(int[] array, int parent) {
        int left = (parent * 2) + 1;
        int right = left + 1;
        if (parent == 0) {
            left = 1;
            right = 2;
        }
        int greatest = parent;
        if (left <= total && (array[left] >= array[greatest])) {
            greatest = left;
        }
        if (right <= total && array[right] >= array[greatest]) {
            greatest = right;
        }
        if (greatest != parent) {
            swap(array, parent, greatest);
            heapify(array, greatest);
        }
    }

    static void sort(int[] array) {
        total = array.length - 1;
        for (int i = total; i > 0; i--) {
            swap(array, 0, i);
            total--;
            heapify(array, 0);
        }
    }

    public static void main(String[] args) {
        System.out.println("HEAP SORT - O[NlogN), space O(N)");

        int[] arr = {12, 3, 8, 4, 2, 9, 15, 1, 7, 6};
        System.out.println("Original input: \n" + Arrays.toString(arr));

        // do max heap, start from the "last parent"
        total = arr.length - 1;
        for (int i = total / 2; i >= 0; i--) {
            heapify(arr, i);
        }
        System.out.println("Maxheap: \n" + Arrays.toString(arr));

        sort(arr);
        System.out.println("Sorted array: \n" + Arrays.toString(arr));
    }
}
