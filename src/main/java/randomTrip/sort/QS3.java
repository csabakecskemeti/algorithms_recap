package randomTrip.sort;

/**
 * Created by kecso on 1/2/18.
 */
public class QS3 {

    public static void main(String[] args) {
        System.out.println("QS in 2018");
        int[] arr = {2,4,7,1,8,9,5,3,6};
        printArray(arr);
        qs(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void qs(int[] arr, int left, int right) {
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
            qs(arr, left, pivot - 1);
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

    private static void printArray(int[] arr) {
        for(int i: arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
