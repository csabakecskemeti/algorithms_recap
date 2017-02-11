package com.sort;

import java.util.Arrays;

/**
 * Created by kecso on 2/10/17.
 */
public class QuickSort {
    static int[] sort(int[] array, int low, int high) {
        if (low > high) {
            return array;
        }
        int mid = low + (high - low)/2;
        int pivot = array[mid];
        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        if (low < j) {
            sort(array, low, j);
        }
        if (high > i) {
            sort(array, i, high);
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println("QUICK SORT - usually O(NlogN)");

        int[] arr = {12, 3, 8, 4, 2, 9, 15, 1};
        System.out.println(Arrays.toString(arr));
        int[] sort = sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(sort));
    }
}
