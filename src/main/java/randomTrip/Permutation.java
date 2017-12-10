package randomTrip;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kecso on 10/15/17.
 */
public class Permutation {
    public static void main(String[] args) {
        System.out.println("Permutation demo");
        int[] array = {1, 2, 3};
//        Arrays.toString(array);
        permutate(array, 0, array.length - 1);
        Map<Integer, Integer> m = new HashMap<>();

    }

    public static void permutate(int[] array, int left, int right) {
        if (array != null) {
            if (left == right) {
                System.out.println(Arrays.toString(array));
            } else {
                for (int i = left; i <= right; i++) {
                    swap(array, left, i);
                    permutate(array, left + 1, right);
                    swap(array, i, left);
                }
            }
        }
    }

    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
