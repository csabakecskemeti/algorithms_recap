package randomTrip.trackback;

/**
 * Created by kecso on 10/12/17.
 */
public class EightQueens {
    public static void main(String[] args) {
        System.out.println("9 queens problem with trackback");
        int[][] table = new int[8][8];
        initTable(table);
        printTable(table);
        int targetQueen = 8;
        if (placeQueen(table, targetQueen)) {
            printTable(table);
        } else {
            System.out.println("Can't do it");
        }



    }

    public static boolean placeQueen(int[][] table, int targetQueen) {
        if (targetQueen > 0) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (isPossible(table, i, j)) {
                        table[i][j] = 1;
                        if (placeQueen(table, targetQueen - 1)) {
                            return true;
                        } else {
                            table[i][j] = 0;
                        }
                    }
                }
            }
            return false;
        } else {
            return true;
        }
    }

    public static boolean isPossible(int[][] table, int x, int y) {
        // row
        for (int i = 0; i < table[x].length; i++) {
            if (table[x][i] > 0) {
                return false;
            }
        }
        // column
        for (int i = 0; i < table.length; i++) {
            if (table[i][y] > 0) {
                return false;
            }
        }
        // diagonal
        for (int i = 0; i <= Math.min(table.length - 1 - x, table[x].length - 1 - y); i++) {
            if (table[x + i][y + i] > 0) {
                return false;
            }
        }
        for (int i = 0; i <= Math.min(x, y); i++) {
            if (table[x - i][y - i] > 0) {
                return false;
            }
        }
        for (int i = 0; i <= Math.min(table.length - 1 - x, y); i++) {
            if (table[x + i][y - i] > 0) {
                return false;
            }
        }
        for (int i = 0; i <= Math.min(x, table[x].length - 1 - y); i++) {
            if (table[x - i][y + i] > 0) {
                return false;
            }
        }

        return true;
    }

    public static void printTable(int[][] table) {
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            for (int bb: table[i]) {
                System.out.print(bb + " ");
            }
            System.out.println();
        }
    }

    public static void initTable(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = 0;
            }
        }
    }
}
