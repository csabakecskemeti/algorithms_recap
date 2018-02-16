package randomTrip;

/**
 * Created by kecso on 2/1/18.
 */
public class Perm4 {
    public static void main(String[] args) {
        System.out.println("permutation demo");
        int[] arr = {1, 2, 3};
        //printArr(arr);
        perm(arr, 0);
    }

    public static void perm(int[] arr, int idx) {
        if (idx == arr.length) {
            printArr(arr);
        }
        for(int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            perm(arr, idx + 1);
            swap(arr, i, idx);
        }
    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void printArr(int[] arr) {
        for (int i: arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

}
