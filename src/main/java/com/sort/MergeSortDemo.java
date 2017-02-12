package com.sort;

import java.util.Arrays;

/**
 * Created by kecso on 2/10/17.
 */
public class MergeSortDemo {
    public static void main(String[] args) {
        System.out.println("MERGE SORT -  O(NlogN)");

        int[] arr = {12, 3, 8, 4, 2, 9, 46, 56, 15, 1, 1};
        System.out.println(Arrays.toString(arr));
        MergeSort mergeSort = new MergeSort();
        int[] sort = mergeSort.prepareArray(arr);
        System.out.println(Arrays.toString(sort));
    }
}

class MergeSort {
    int[] array;
    int[] tempArray;

    int[] prepareArray(int[] array) {
        this.array = array;
        this.tempArray = new int[array.length];
        return doMergeSort(0, array.length - 1);
    }

    int[] doMergeSort(int low, int high) {
//        System.out.println("low " + low + " " + " high " + high);
        if (low < high) {
            int mid = low + (high - low) / 2;
            doMergeSort(low, mid);
            doMergeSort(mid + 1, high);
            mergePart(low, mid, high);
        }
        return array;
    }

    void mergePart(int low, int mid, int high) {
//        System.out.println("merge: " + low + " " + high + " mid: " + mid);
        // copy to temp
        for (int i = low; i <= high; i++) {
            tempArray[i] = array[i];
        }
        int i = low;
        int idx = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            if (tempArray[i] <= tempArray[j]) {
                array[idx] = tempArray[i];
                i++;
            } else {
                array[idx] = tempArray[j];
                j++;
            }
            idx++;
        }
        while (i <= mid) {
            array[idx] = tempArray[i];
            i++;
            idx++;
        }
        while (j <= high) {
            array[idx] = tempArray[j];
            j++;
            idx++;
        }
//        System.out.println(Arrays.toString(array));
    }
}
