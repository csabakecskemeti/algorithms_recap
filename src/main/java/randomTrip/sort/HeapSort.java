package randomTrip.sort;

import java.util.Arrays;

/**
 * Created by kecso on 2/19/18.
 */
public class HeapSort {
    public static void main(String[] args) {
        System.out.println("heapsort... again");
        int[] arr = {7, 4, 9, 23, 6, 13, 12, 4};
        System.out.println(Arrays.toString(arr));
        buildMaxHeap(arr);
        System.out.println(Arrays.toString(arr));
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapify(int[] arr, int parent, int heapSize) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < heapSize
                && arr[left] > arr[max]) {
            max = left;
        }
        if (right < heapSize
                && arr[right] > arr[max]) {
            max = right;
        }
        if (max != parent) {
            swap(arr, parent, max);
            heapify(arr, max, heapSize);
        }
    }

    public static void heapSort(int[] arr, int heapSize) {
        for(int i = heapSize - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, --heapSize);
        }
    }

    public static void buildMaxHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
