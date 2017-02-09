package com.search;

/**
 * Created by kecso on 2/9/17.
 */
public class LinearSearch {
    public static void main(String[] args) {
        System.out.println("LINEAR SEARCH");
        DataSet dataSet = new DataSet(1000000);
        int number = 700;
        boolean isFound = false;
        for (int i = 0; i < dataSet.data.length; i++) {
            dataSet.numberTry++;
            if (number == dataSet.data[i]){
                System.out.println("found, iterations: " + dataSet.numberTry);
                isFound = true;
                break;
            }
        }
        System.out.println(isFound);
    }
}
