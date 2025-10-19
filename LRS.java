public class LRS {

    // Function to find length of Longest Repeating Subsequence
    static int lrs(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println("DP Matrix:");
        System.out.print("    ");
        for (int k = 0; k < n; k++) System.out.print(s.charAt(k) + " ");
        System.out.println();
        for (int i = 0; i <= n; i++) {
            if (i > 0)
                System.out.print(s.charAt(i - 1) + " ");
            else
                System.out.print("  ");
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        String lrs = backtrack(s, dp, n, n);
        System.out.println("\nLongest Repeating Subsequence: " + lrs);
        System.out.println("Length of LRS: " + dp[n][n]);

        return dp[n][n];
    }

    static String backtrack(String s, int[][] dp, int i, int j) {
        if (i == 0 || j == 0)
            return "";

        if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
            return backtrack(s, dp, i - 1, j - 1) + s.charAt(i - 1);
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            return backtrack(s, dp, i - 1, j);
        } else {
            return backtrack(s, dp, i, j - 1);
        }
    }

    public static void main(String[] args) {
        String s = "AABEBCDD";
        lrs(s);
    }
}
