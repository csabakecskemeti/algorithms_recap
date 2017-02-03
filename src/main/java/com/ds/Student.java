package com.ds;

/**
 * Created by kecso on 2/2/17.
 */
public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " " + age;
    }
}
