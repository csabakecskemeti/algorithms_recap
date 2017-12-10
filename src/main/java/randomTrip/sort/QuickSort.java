package randomTrip.sort;

/**
 * Created by kecso on 10/11/17.
 */
public class QuickSort {
    public static void main(String[] args) {
        System.out.println("Demo quicksort");
        int[] array = {5, 3, 9, 2, 1, 7, 4, 8, 6, 10};
        printArray(array);
        quicksort(array, 0, array.length - 1);
        printArray(array);

        int[] array2 = {55, 124, 9, 200, 134, 7, 4, 8, 6, 10};
        printArray(array2);
        quicksort(array2, 0, array.length - 1);
        printArray(array2);

        int[] g = {10,9,8,7};
        printArray(g);
        quicksort(g, 0, g.length - 1);
        printArray(g);

        int[] s = {5,6,7,8};
        printArray(s);
        quicksort(s, 0, s.length - 1);
        printArray(s);

    }

    private static void quicksort(int[] array, int left, int right) {
        int pointer = left;
        int pivot = right;
        while (pointer < pivot) {
            if (array[pointer] > array[pivot]) {
                if (pointer + 1 == pivot) {
                    swap(array, pointer, pivot);
                } else {
                    swap(array, pivot - 1, pivot);
                    swap(array, pointer, pivot);
                }
                pivot--;
            } else {
                pointer++;
            }
        }

        if (pivot > left) {
            quicksort(array, left, pivot - 1);
        }
        if (pivot < right) {
            quicksort(array, pivot + 1, right);
        }
    }


    private static void swap(int[]array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }
}
