package com.array;

import java.util.Arrays;

/**
 * Created by kecso on 3/26/17.
 */
public class LIS2 {
    public static void main(String[] args) {

//        int[] arr = {0, 4, -1, -1, -1, -1, -1, -1};
////        int[] arr = {0, 2, 4, 8, -1, -1, -1, -1};
//        System.out.println(Arrays.toString(arr));
//        int idx = binarySearch(arr, 1, -23);
//        if (idx >= 0) {
//            System.out.println(arr[idx]);
//        } else {
//            System.out.println("All elements in the array are smaller");
//        }

        System.out.println("LIS ");
        int[] array = {2, 1, 0, 4, 3, 7, 9, 5, 8, 12};
        System.out.println(Arrays.toString(array));
        lis(array);
        System.out.println("       " + Arrays.toString(array));
    }

    public static void lis(int[] array) {
        // might be using Integer is better?
        int[] lis = new int[array.length];
        int[] parent = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            lis[i] = -1;
            parent[i] = -1;
        }
        lis[0] = array[0];
        int last = 0;
        for (int i = 1; i < array.length; i++) {
            int smallerThanIdx = binarySearch(lis, last, array[i]);
            if (smallerThanIdx >= 0) {
                lis[smallerThanIdx] = array[i];
            } else {
                last++;
                lis[last] = array[i];
            }
            if (last > 0) {
                parent[i] = lis[last - 1];
            }
            System.out.println(i + " - " + array[i]);
            System.out.println("smaller than index " + smallerThanIdx);
            System.out.println("last " + last);
            System.out.println("lis: " + Arrays.toString(lis));
            System.out.println("parent " +  Arrays.toString(parent));
        }

        // reconstruct LIS
        int lisLength = 0;
        while (lis[lisLength] != -1) {
            lisLength++;
        }
        System.out.println("LIS length: " + lisLength);
        int biggest = lis[lisLength - 1];
        int[] result = new int[lisLength];
        result[--lisLength] = biggest;

        int biggestIdx = 0;
        while(biggest != array[biggestIdx]) {
            biggestIdx++;
        }
        for(int j = lisLength; lisLength > 0; ) {
            int p = parent[biggestIdx--];
            if (p < result[lisLength]) {
                result[--lisLength] = p;
            }
        }

        System.out.println("LIS: " + Arrays.toString(result));
    }

    public static int binarySearch(int[] array, int high, int x) {
        int low = 0;
        int mid = low + (high - low) / 2;
        while (low < high) {
            if (array[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + (high - low) / 2;
        }
        if (array[low] < x) {
            return -1;
        }
        return low;
    }

}
