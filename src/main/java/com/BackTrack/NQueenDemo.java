package com.BackTrack;

/**
 * Created by kecso on 2/27/17.
 */
public class NQueenDemo {
    public static void main(String[] arg) {
        System.out.println("NQueenDemo");
        NQueen nQueen = new NQueen(8);
        nQueen.placeNQueens();
    }
}
