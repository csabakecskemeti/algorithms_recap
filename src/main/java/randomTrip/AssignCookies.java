package randomTrip;

/**
 * Created by kecso on 11/27/17.
 */
public class AssignCookies {

    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};

        System.out.println(findContentChildren(g, s));
    }
    public static int findContentChildren(int[] g, int[] s) {
        int res = 0;
        if (g == null || s == null || g.length < 1 || s.length < 1) {
            return res;
        }
        // bubblesort(g);
        // bubblesort(s);
        quicksort(g, 0, g.length - 1);
        quicksort(s, 0, s.length - 1);
        printArray(g);
        printArray(s);

        int gi = g.length - 1;
        for (int i = s.length - 1; i >= 0; i--) {
            int gis = gi;
            while (gis >= 0) {
                System.out.println("s idx: " + i + " sval " + s[i] + " g idx " + gi + " gval " + g[gi]);
                if (s[i] >= g[gi]) {
                    res++;
                    gi = --gis;
                    break;
                } else {
                    gi = --gis;
                }
                // gi = gis;
            }
        }
        return res;
    }

    public static void quicksort(int[] arr, int left, int right) {
        int pointer = left;
        int pivot = right;
        while (pointer < pivot) {
            if (arr[pointer] > arr[pivot]) {
                if (pointer + 1 == pivot) {
                    swap(arr, pointer, pivot);
                } else {
                    swap(arr, pivot - 1, pivot);
                    swap(arr, pointer, pivot);
                }
                pivot--;
            } else {
                pointer++;
            }
        }
        if (pivot > left) {
            quicksort(arr, left, pivot - 1);
        }
        if (pivot < right) {
            quicksort(arr, pivot + 1, right);
        }
    }

    public static void bubblesort(int[] arr) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }
}
