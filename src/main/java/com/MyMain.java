package com;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;

/**
 * Created by kecso on 3/15/17.
 */
public class MyMain {
    public static void main(String[] args) {

        String a = null;
        String b = null;
        System.out.println(">> " + ObjectUtils.equals(a,b));

        System.out.println("Test abstract static member");
        MyClass mc = new MyClass();
        System.out.println(Arrays.toString(mc.sa));

        MyOtherClass moc = new MyOtherClass();
        System.out.println(Arrays.toString(moc.sa));

        System.out.println(Arrays.toString(mc.sa));

    }
}
