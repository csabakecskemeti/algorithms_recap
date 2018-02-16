package randomTrip;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kecso on 2/11/18.
 */
public class QS5 {
    public static void main(String... args) {
        System.out.println("QS 5");
        int[] array = {3, 7 , 13, 45, 7465, 65, 4, 3};
        printArray(array);
        qs(array, 0, array.length - 1);
        printArray(array);
    }

    public static void qs(int[] arr, int left, int right) {
        if (arr == null) {
            return;
        }
        int ptr = left;
        int pivot = right;
        while(ptr <= pivot) {
            if (arr[ptr] > arr[pivot]) {
                if (ptr + 1 != pivot) {
                    swap(arr, pivot, pivot - 1);
                }
                swap(arr, ptr, pivot);
                pivot--;
            } else {
                ptr++;
            }
        }
        if (left < pivot - 1) {
            qs(arr, left, pivot - 1);
        }
        if (right > pivot + 1) {
            qs(arr, pivot + 1, right);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void printArray(int[] arr) {
         for (int i : arr) {
             System.out.print(i + ",");
         }
         System.out.println();
    }

}
