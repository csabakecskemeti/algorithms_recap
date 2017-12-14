package randomTrip;

/**
 * Created by kecso on 12/13/17.
 */
public class Perm2 {
    public static void main(String[] args) {
        System.out.println("Permutation 2");
        int[] nums = {1,2,3};
//        printArray(nums);
        premutation(0, nums);
    }

    private static void premutation(int level, int[] arr) {
        if (level == arr.length - 1) {
            printArray(arr);
        }
        for(int i = level; i < arr.length; i++) {
            swap(arr, level, i);
            premutation(level + 1, arr);
            swap(arr, level, i);
        }
    }

    private static void swap(int[] arr, int a, int b) {
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
