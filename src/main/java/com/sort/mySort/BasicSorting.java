package com.sort.mySort;

import java.util.Arrays;

/**
 * Created by kecso on 3/4/17.
 */
public class BasicSorting {
    public static void main(String[] args) {
        System.out.println("Demo basic sort algorithms");
        int[] array = {7, 4, 5, 6, -2, 8};

        System.out.println("bubble");
        System.out.println(Arrays.toString(bubbleSort(array)));

        System.out.println("quick");
        int[] array2 = {7, 4, 5, 6, -2, 8};
        System.out.println(Arrays.toString(quickSort(array2, 0, array2.length - 1)));

        System.out.println("quicksort orig");
        int[] array3 = {7, 4, 5, 6, -2, 8};
        System.out.println(Arrays.toString(quickSort(array3, 0, array3.length - 1)));
    }

    public static int[] bubbleSort(int[] array) {
        int lastUnsorted = array.length - 1;
        while(lastUnsorted > 0) {
            for(int i = 1; i <= lastUnsorted; i++) {
                if(array[i - 1] > array[i]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                }
            }
            lastUnsorted--;
        }
        return array;
    }

    public static int[] quickSort(int[] array, int start, int end) {
        if(start >= end) {
            return array;
        }
        int pivotIndex = start + (end - start) / 2;
        int left = start;
        int right = end;
        while(left <= right) {
            while(array[left] < array[pivotIndex]) {
                left++;
            }
            while(array[pivotIndex] < array[right]) {
                right--;
            }
            if(left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            }
        }
        if(start < right) {
            array = quickSort(array, start, pivotIndex - 1);
        }
        if(end > left){
            array = quickSort(array, pivotIndex, end);
        }
        return array;
    }

    public static int[] quickSortOrig(int[] array, int start, int end) {
        if(start >= end) {
            return array;
        }
        int pivotIndex = start + (end - start) / 2;
        int left = start;
        int right = end;
        while(left < pivotIndex && pivotIndex < right) {
            while(array[left] < array[pivotIndex]) {
                left++;
            }
            while(array[pivotIndex] < array[right]) {
                right--;
            }
            if(left < right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            }
        }
        array = quickSortOrig(array, start, pivotIndex - 1);
        return quickSortOrig(array, pivotIndex, end);
    }
}
