package nextRound2018.tree;

public class Sortings {
    public static void main(String[] args) {
        System.out.println("Sortings");
        int[] arr = {3,6,5,8,7,2,1,1,5,5,9,4};
        printArray(arr);
        System.out.println("Quicksort");
        quicksort(arr, 0, arr.length - 1);
        printArray(arr);
        
    }
    
    static void quicksort(int[] arr, int left, int right) {
        int pivot = right;
        int i = left;
        while (i < pivot) {
            if (arr[i] > arr[pivot]) {
                if (i != pivot - 1) {
                    swap(pivot, pivot - 1, arr);
                }
                swap(pivot, i, arr);
                pivot--;
            } else {
                i++;
            }
        }
        if (left < pivot) {
            quicksort(arr, left, pivot - 1);
        }
        if (pivot < right) {
            quicksort(arr, pivot + 1, right);
        }
    }
    
    static void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }
}
