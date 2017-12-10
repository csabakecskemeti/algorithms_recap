package datastructuresAndAlgo.recursionAndBacktrack;

/**
 * Created by kecso on 12/10/17.
 */
public class TowersOfHanoi {
    public static void main(String[] args) {
        System.out.println("Towers of Hanoi");
        th(3, 'A', 'B', 'C');
    }

    public static void th(int n, char src, char trg, char tmp) {
//        baseCase
        if (n == 1) {
            System.out.println("move disk 1 from " + src + " to " + trg);
        } else {
            th (n - 1, src, tmp, trg);
            System.out.println("move disk " + n + " from " + src + " to " + trg);
            th (n-1, tmp, trg, src);
        }
    }
}
