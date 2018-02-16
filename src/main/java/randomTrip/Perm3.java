package randomTrip;

/**
 * Created by kecso on 1/2/18.
 */
public class Perm3 {
    public static void main(String[] args) {
        System.out.println("Permutation again");
        int[] arr = {1,2,3};
        printArr(arr);
        System.out.println();
        permutation(arr, 0);
    }

    private static void permutation(int[] arr, int left) {
        if (left == arr.length - 1) {
            printArr(arr);
        }
        for(int i = left; i < arr.length; i++) {
            swap(arr, left, i);
            permutation(arr, left + 1);
            swap(arr, left, i);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static void printArr(int[] arr) {
        for(int i: arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
