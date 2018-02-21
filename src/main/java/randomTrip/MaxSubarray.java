package randomTrip;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * Created by kecso on 10/15/17.
 */
public class MaxSubarray {
    public static void main (String[] args) {
        System.out.println("Maximum Sub Array demo");
        int[] array = {1,2,-6,5,3,3,-8,2,2,-3,9,1,-11};
        System.out.println(Arrays.toString(array));
        System.out.println(maxSubArray(array));
    }

    public static int maxSubArray(int[] array) {
        int max = 0;
        int curr = 0;
        int startIdx = 0;
        int endIdx = -1;
        for(int i = 0; i < array.length; i++) {
            if (curr + array[i] > 0) {
                curr = curr + array[i];
                if (curr > max) {
                    max = curr;
                    endIdx = i;
                }
            } else {
                curr = 0;
                // ez nem is jo
                startIdx = i + 1;
            }
        }
        System.out.println("Max: " + max + " start: " + startIdx + " end: " + endIdx);
        return max;
    }
}
