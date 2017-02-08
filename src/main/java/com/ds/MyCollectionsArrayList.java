package com.ds;

import java.util.ArrayList;

/**
 * Created by kecso on 2/7/17.
 */
public class MyCollectionsArrayList {
    public static void main(String[] args) {
        System.out.println("ARRAY LIST");
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Developer");
        arrayList.add("Tester");
        arrayList.add("Maneger");

//        System.out.println(arrayList.get(0));
        arrayList.remove(0);
        for(String s: arrayList) {
            System.out.println(s);
        }

        /*
            ArrayList is implemented with dynamic array, so use if we would
            like to read data that's fast, but if we inser and remove that
            does a lot of array copy!!!
        */

        System.out.println("\n");
        // Array class
        ArrayList<Employee> arrayListE = new ArrayList<Employee>();
        arrayListE.add(new Employee("Csaba", 36));
        arrayListE.add(new Employee("Bla", 33));
        for (Employee e: arrayListE) {
            System.out.println(e.name);
        }

    }

    static class Employee{
        String name;
        int age;
        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
