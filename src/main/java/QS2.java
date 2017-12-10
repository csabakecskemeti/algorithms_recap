/**
 * Created by kecso on 12/10/17.
 */
public class QS2 {
    public static void main(String[] args) {
        System.out.println("QS megint");
        int[] arr = {5,7,23,6,8,5,3,2,54,56,7,8};
        printArray(arr);
        qs(arr, 0, arr.length - 1);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    public static void qs(int[] arr, int left, int right) {
        int pointer = left;
        int pivot = right;
        while (pointer < pivot) {
            if (arr[pointer] > arr[pivot]) {
                if (pointer + 1 != pivot) {
                    swap(arr, pivot, pivot - 1);
                }
                swap(arr, pointer, pivot);
                pivot--;
            } else {
                pointer++;
            }
        }
        if (pivot - 1 > left) {
            qs(arr, left, pivot -1);
        }
        if (pivot + 1 < right) {
            qs(arr, pivot + 1, right);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
