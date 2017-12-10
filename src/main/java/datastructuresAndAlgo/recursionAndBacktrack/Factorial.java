package datastructuresAndAlgo.recursionAndBacktrack;

/**
 * Created by kecso on 12/10/17.
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println("Calculate factorial");
        System.out.println(fact(10));
    }

    private static int fact(int n) {
//        base case
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
}
