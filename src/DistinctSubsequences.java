import java.util.Arrays;
import java.util.Enumeration;

//leetcode 115
public class DistinctSubsequences {

    public static int tabulate(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (j == n) {
                    dp[i][j] = 1;
                } else if (i == m) {
                    dp[i][j] = 0;
                } else {
                    char c = s.charAt(i);
                    char d = t.charAt(j);

                    if (c == d) {
                        dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                    } else {
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }
        }
        return dp[0][0];
    }


    public static int solve(int i, int j, String s, String p, int[][] dp) {
        if (j == p.length()) return 1;
        if (i == s.length()) return 0;

        char c = s.charAt(i);
        char d = p.charAt(j);
        if (dp[i][j] >= 0) return dp[i][j];
        if (c == d) {
            return dp[i][j] = solve(i + 1, j + 1, s, p, dp) + solve(i + 1, j, s, p, dp);
        }

        return dp[i][j] = solve(i + 1, j, s, p, dp);
    }

    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        solve(0, 0, s, t, dp);
        return dp[0][0];
    }


    public static void main(String[] args) {
        String s = "rabb";
        String t = "rab";
        System.out.println(tabulate(s, t));
    }
}
