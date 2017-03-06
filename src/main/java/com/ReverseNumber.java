package com;

/**
 * Created by kecso on 3/5/17.
 */
public class ReverseNumber {
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("reverse number");
        System.out.println(reverseNumber(12302));
    }

    public static int reverseNumber(int number) {
        int res = 0;
        int i = 0;
        while(number > 0) {
            res = res * 10;
            res += number%10;
            number = number / 10;
        }
        return res;
    }
}
