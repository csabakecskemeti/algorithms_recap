package com.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kecso on 3/8/17.
 */
public class MaximumIncreasingSequence {
    public static void main(String[] args) {
        System.out.println("Maximum Increasing Sequence in an array");
        int[] array = {2, 1, 0, 4, 3, 7, 9, 5};

//        System.out.println(min(array));

//        System.out.println("The array: " + Arrays.toString(array));
//        System.out.println("Longest inc seq: " + Arrays.toString(maxIncSeq(array)));
        int[] array2 = {3, 2, 6, 4, 5, 1};
        System.out.println("The array: " + Arrays.toString(array2));
//        myIncSeq(array2);

        getLis(array2);

    }

    public static int[] maxIncSeq(int[] array) {
        // stores the index of the predecessor of X[k] in the longest increasing subsequence ending at X[k].
        int[] p = new int[array.length];
        for (int i = 0; i < p.length; i++) {
            p[i] = 0;
        }
        // stores the index k of the smallest value X[k] such that there is an increasing subsequence of
        // length j ending at X[k] on the range k ≤ i. Note that j ≤ (i+1), because j ≥ 1 represents
        // the length of the increasing subsequence, and k ≥ 0 represents the index of its termination.
        int[] m = new int[array.length + 1];
        for (int i = 0; i < m.length; i++) {
            m[i] = 0;
        }
        int l = 0;
        for(int i = 0; i < array.length; i++){
            int lo = 1;
            int hi = l;
            // Binary search for the largest positive j ≤ L
            // such that array[m[j]] < array[i]
            // MY: is there any smaller ending longest than array[i]
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (array[m[mid]] < array[i]) {
                    lo =  mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            // After searching, lo is 1 greater than the
            // length of the longest prefix of X[i]
            int newL = lo;

            // The predecessor of X[i] is the last index of
            // the subsequence of length newL-1
            p[i] = m[newL - 1];
            m[newL] = i;

            if (newL > l) {
                // If we found a subsequence longer than any we've
                // found yet, update L
                l = newL;
            }
            System.out.println("length " + l + " index " + i + " value " + array[i]);
            System.out.println("p " + Arrays.toString(p));
            System.out.println("m " + Arrays.toString(m));
        }
        // Reconstruct the longest increasing subsequence
        int[] s = new int[l];
        int k = m[l];
        for (int i = l - 1; i >= 0; i--) {
            s[i] = array[k];
            k = p[k];
        }

        return s;
    }

    public static int min(int[] array) {
        int lo = 0;
        int hi = array.length;
        // Binary search for the largest positive j ≤ L
        // such that array[m[j]] < array[i]
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (array[mid] < array[lo]) {
                lo =  mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return array[lo];
    }

    // https://youtu.be/4fQJGoeW5VE
    // ez szar meg
    public static void myIncSeq(int[] array) {
        if (array == null) {
            return;
        }
        ArrayList<Integer>[] longest = new ArrayList[array.length];
        for (int i = 0; i < array.length; i++) {
            longest[i] = new ArrayList<Integer>();
        }
        longest[0].add(array[0]);
        for (int i = 1; i < array.length; i++) {
            for(int j = 0; j < i; j++) {
                if (array[j] < array[i]
                        && longest[i].size() < longest[j].size() + 1) {
                    longest[i] = longest[j];
                }
            }
            longest[i].add(array[i]);
            System.out.println(longest[i].toString());
        }

        System.out.println("==========");
        for (ArrayList<Integer> al : longest) {
            System.out.println(al.toString());
        }
    }

    public static void getLis(int[] array) {
        int[] lis = new int[array.length];
//        for (int i = 0; i < lis.length; i++) {
//            lis[i] = 1;
//        }
        lis[0] = 1;
        for (int i = 1; i < array.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(lis));
    }
}
