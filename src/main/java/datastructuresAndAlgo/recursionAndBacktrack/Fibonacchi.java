package datastructuresAndAlgo.recursionAndBacktrack;

/**
 * Created by kecso on 12/10/17.
 */
public class Fibonacchi {
    public static void main(String[] args) {
        System.out.println("Fibonacchi series");
//        fbRecursive(5);
        printArray(fbIterrative(10));
    }

    private static void printArray(int[] arr) {
        for (int i: arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

//     this is a demonstrartion how much tim ethe recursive will do the same calculation -> iter better
    private static int fbRecursive(int n) {
//        base case
        if (n == 0) {
            System.out.println(0);
            return 0;
        } else if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int nn = fbRecursive(n - 2) + fbRecursive(n - 1);
            System.out.println(nn);
            return(nn);
        }
    }

    private static int[] fbIterrative(int n) {
        int[] result = new int[n + 1];
        int i = 0;
        while (i <= n) {
            if (i == 0) {
                result[0] = 0;
            } else if (i == 1) {
                result[i] = 1;
            } else {
                result[i] = result[i - 1] + result[i - 2];
            }
            i++;
        }
        return result;
    }
}
