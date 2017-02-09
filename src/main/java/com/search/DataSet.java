package com.search;

/**
 * Created by kecso on 2/9/17.
 */
public class DataSet {
    int [] data;
    int numberTry;
    public DataSet(int size) {
        data = new int[size];
        for(int i = 1; i <= size; i++) {
            data[i - 1] = i;
        }
        numberTry = 0;
    }
}
