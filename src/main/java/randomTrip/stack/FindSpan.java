package randomTrip.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by kecso on 1/29/18.
 */
public class FindSpan {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 3, 5, 6, 7, 5};
        System.out.println(Arrays.toString(findSpan(arr)));
    }

    public static int[] findSpan(int[] arr) {
         Stack<Integer> stack = new Stack<>();
         int[] res = new int[arr.length];
         int p;
         for(int i = 0; i < arr.length; i++) {
             while (!stack.empty() && arr[i] > arr[stack.peek()]) {
                 stack.pop();
             }
             res[i] = (stack.empty())? (i + 1) : (i - stack.peek());
             stack.push(i);
         }
        return res;
    }
}
