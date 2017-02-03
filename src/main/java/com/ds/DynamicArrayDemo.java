package com.ds;

/**
 * Created by kecso on 2/2/17.
 */
public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<Integer>();
        dynamicArray.put(1);
        System.out.println("dymanic array size " + dynamicArray.getSize());
        dynamicArray.put(2);
        System.out.println("dymanic array size " + dynamicArray.getSize());
        dynamicArray.put(2);
        System.out.println("dymanic array size " + dynamicArray.getSize());
        dynamicArray.put(2);
        System.out.println("dymanic array size " + dynamicArray.getSize());
        dynamicArray.put(2);
        System.out.println("dymanic array size " + dynamicArray.getSize());

        System.out.println("Elements:");
        for (int i = 0; i < dynamicArray.getSize(); i++) {
            System.out.println(dynamicArray.get(i));
        }
    }
}
