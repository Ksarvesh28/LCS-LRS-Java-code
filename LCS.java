import java.util.*;


public class LCS {


    static class Cell {
        int val;
        char dir;
    }


    public static void main(String[] args) {
        String a = "AGCCCTAAGGGCTACCTAGCTT";
        String b = "GACAGCCTACAAGCGTTAGCTTG";
        int n = a.length();
        int m = b.length();
        Cell[][] c = new Cell[n + 1][m + 1];


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                c[i][j] = new Cell();
            }
        }


        lcs(a, b, c);
        System.out.println("Length of LCS: " + c[n][m].val);


        System.out.print("Here's the cost matrix :");
        for(int i = 0 ; i<= n ; i++){
            for(int j = 0 ; j<=m ; j++){
                System.out.print("["+c[i][j].val+"/"+c[i][j].dir+"]");


            }
            System.out.println();
        }
    }


    static void lcs(String a, String b, Cell[][] c) {
        int n = a.length();
        int m = b.length();


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    c[i][j].val = 0;
                    c[i][j].dir = 'h';
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    c[i][j].val = c[i - 1][j - 1].val + 1;
                    c[i][j].dir = 'd';
                } else {
                    if (c[i - 1][j].val >= c[i][j - 1].val) {
                        c[i][j].val = c[i - 1][j].val;
                        c[i][j].dir = 'u';
                    } else {
                        c[i][j].val = c[i][j - 1].val;
                        c[i][j].dir = 's';
                    }
                }
            }
        }
    }
}
