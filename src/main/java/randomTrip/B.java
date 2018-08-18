package randomTrip;

/**
 * Created by kecso on 11/10/17.
 */
public class B {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,2,3,4,5};
        for (int i: arr) {
            f(i);
            System.out.println(i);
        }
    }

    private static void f(int i) throws Exception {
        if (i == 4) {
            throw new Exception("just");
        }
    }
}
