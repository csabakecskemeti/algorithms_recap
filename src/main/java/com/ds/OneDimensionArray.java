package com.ds;

import java.util.Arrays;

/**
 * Created by kecso on 2/2/17.
 */
public class OneDimensionArray {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        numbers[0] = 20;
        numbers[1] = 5;
        numbers[2] = 10;
        numbers[3] = 6;
        numbers[4] = 11;
        for (int i: numbers) {
            System.out.println("number: " + i);
        }
        System.out.println(Arrays.toString(numbers));

        Student[] students = new Student[4];
        students[0] = new Student("name1", 1);
        students[1] = new Student("name2", 2);
        students[2] = new Student("name3", 3);
        students[3] = new Student("name4", 4);
        for(Student student: students) {
            System.out.println(student.toString());
        }
    }
}
