package com.search;

/**
 * Created by kecso on 2/9/17.
 */
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("BINARY SEARCH - O(logN)");
        int number = 176543;
        boolean isFound = false;
        DataSet dataSet = new DataSet(1000000);
        int low = 0;
        int high = dataSet.data.length;
        int mid = 0;
        while(!isFound) {
            if (low > high) {
                System.out.println("Number not found");
                break;
            }
            dataSet.numberTry++;
            mid = low + ((high - low) / 2);
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
