package randomTrip;

/**
 * Created by kecso on 11/10/17.
 */
public class A {

    public static void main(String[] args) {
        System.out.println("Prem demo");

        int[] arr = {1,2,3};
        perm(arr, 0, arr.length - 1);
    }

    private static void perm(int[] arr, int left, int right) {
        if (left == right) {
            // ha nincs mit cserelni, print
            printArray(arr);
        } else {
            // megyek vegig a subarray-en es cserelgetem az elemeket,
            // es az egyel kisebb subarray-t lekuldom permutaciora
            for (int i = left; i <= right; i++){
                swap(left, i, arr);
                perm(arr, left + 1, right);
                swap(i, left, arr);

            }
        }
    }

    private static void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int x: arr) {
            System.out.print(x);
        }
        System.out.println();
    }
}
