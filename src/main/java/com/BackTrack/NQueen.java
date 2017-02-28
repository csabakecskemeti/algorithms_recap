package com.BackTrack;

import java.util.Arrays;

/**
 * Created by kecso on 2/27/17.
 */
public class NQueen {
    int n;
    short[][] table;
    public NQueen(int n) {
        this.n = n;
        // initialize table
        table = new short[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = 0;
            }
        }
    }

    public void placeNQueens() {
        if (placeNQueens(n, table)) {
            System.out.println("Solved");
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(table[i]));
            }
        } else {
            System.out.println("can't find solution");
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(table[i]));
            }
        }
    }

    private boolean placeNQueens(int nQueen, short[][] currentTable) {
        if (nQueen == 0) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(check(i, j, table)){
                    table[i][j] = 1;
                    if(placeNQueens(nQueen - 1, table)){
                        table[i][j] = 1;
                        return true;
                    } else {
                        table[i][j] = 0;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(int i, int j, short[][] currentTable){
        // check col
        for (int ii = 0; ii < n; ii++) {
            if (currentTable[ii][j] == 1) {
                return false;
            }
        }
        // check row
        for (int jj = 0; jj < n; jj++) {
            if (currentTable[i][jj] == 1) {
                return false;
            }
        }
        // check diag
        int ii = i;
        int jj = j;
        while (ii < n && jj < n) {
            if (currentTable[ii][jj] == 1){
                return false;
            }
            ii++;
            jj++;
        }
        ii = i;
        jj = j;
        while (ii >= 0 && jj >= 0) {
            if (currentTable[ii][jj] == 1){
                return false;
            }
            ii--;
            jj--;
        }
        ii = i;
        jj = j;
        while (ii >= 0 && jj < n) {
            if (currentTable[ii][jj] == 1){
                return false;
            }
            ii--;
            jj++;
        }
        ii = i;
        jj = j;
        while (ii < n && jj >= 0) {
            if (currentTable[ii][jj] == 1){
                return false;
            }
            ii++;
            jj--;
        }
        return true;
    }
}
