package com.search;

/**
 * Created by kecso on 2/9/17.
 */
public class InterpolationSearch {
    public static void main(String[] args) {
        System.out.println("INTERPOLATION SEARCH");
        // to test this we should fill the array with random increasing numbers
        // right now it calculates the index in 1 step
        int number = 34695;
        boolean isFound = false;
        DataSet dataSet = new DataSet(1000000);
        int low = 0;
        int high = dataSet.data.length - 1;
        int mid = 0;
        while(!isFound) {
            if (low > high) {
                System.out.println("Number not found");
                break;
            }
            dataSet.numberTry++;
            mid = low + ((high - low) / (dataSet.data[high] - dataSet.data[low]))*(number - dataSet.data[low]);
//            System.out.println(mid);
            if (number == dataSet.data[mid]) {
                System.out.println("Number found after: " + dataSet.numberTry);
                break;
            } else if (number < dataSet.data[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }
}
