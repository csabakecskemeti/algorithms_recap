/**
 * Created by kecso on 12/7/17.
 */
public class Qs {
    public static void main(String[] args) {
        System.out.println("quicksort demo");
//        int[] array = {2,7,5,6,8,9,1,2};
        int[] array = {2,5,3,8,9,6,134,4};
        printArray(array);
        qs(array, 0, array.length - 1);
        printArray(array);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    private static void qs(int[] arr, int left, int right) {
        int pointer = left;
        int pivot = right;
        while (pointer < pivot) {
            if(arr[pointer] > arr[pivot]) {
                if (pivot != pointer + 1) {
                    swap(arr, pivot, pivot - 1);
                }
                swap(arr, pivot, pointer);
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

}
