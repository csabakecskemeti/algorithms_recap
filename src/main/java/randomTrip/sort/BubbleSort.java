package randomTrip.sort;

/**
 * Created by kecso on 10/12/17.
 */
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("Bubble sort demo");
        int[] array = {1,2,9,5,4,7,8,6,3,10};
        printArray(array);
        bubbleSort(array);
        printArray(array);
    }

    private static void printArray(int[] array) {
        System.out.println();
        for (int i: array) {
            System.out.print(i + ", ");
        }
    }

    private static void bubbleSort(int[] array) {
        boolean swapHappened = true;
        while (swapHappened) {
            swapHappened = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    swapHappened = true;
                }
            }
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
