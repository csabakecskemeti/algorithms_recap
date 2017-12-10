package randomTrip.sort;

/**
 * Created by kecso on 11/28/17.
 */
public class QuickSort2 {
    public static void main (String[] args) {
        System.out.println("QS practice");
        int[] arr = {2,7,5,6,8,9,1,2};
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    private static void quickSort(int[] arr, int left, int right) {
        int pointer = left;
        int pivot = right;
        while (pointer < pivot) {
            if (arr[pointer] > arr[pivot]) {
                if (pointer + 1 != pivot) {
                    swap(arr, pivot, pivot - 1);
                }
                swap(arr, pointer, pivot);
            } else {
                pointer++;
            }
        }
        if (pivot - 1 > left) {
            quickSort(arr, left, pivot - 1);
        }
        if (pivot + 1 < right) {
            quickSort(arr, pivot + 1, right);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
