import java.util.Arrays;

public class GuessHigherOrLower {

    public static int tabulate(int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    min = Math.min(min, k + Math.max(solve(i, k - 1, dp), solve(k + 1, j, dp)));
                }
                dp[i][j] = min == Integer.MAX_VALUE ? 0 : min;
            }
        }
        return dp[1][n];
    }


    public static int solve(int i, int j, int[][] dp) {
        if (i >= j) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min, k + Math.max(solve(i, k - 1, dp), solve(k + 1, j, dp)));
        }

        return dp[i][j] = min;
    }
    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int[] a: dp) {
            Arrays.fill(a, -1);
        }
        return solve(1, n, dp);
    }

    public static void main(String[] args) {
        tabulate(10);
    }
}
