public class LongestCommonSubsequence {

    public static int tabulation(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        int m = s.length();
        int n = p.length();
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m || j == n) {
                    dp[i][j] = 0;
                } else {
                    char c = s.charAt(i);
                    char d = p.charAt(j);

                    if (c == d) {
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static int solve(int i, int j, String s, String p, int[][] dp) {
        if (i == s.length() || j == p.length()) {
            return 0;
        }

        if (dp[i][j] >= 0) {
            return dp[i][j];
        }
        char c = s.charAt(i);
        char d = p.charAt(j);
        if (c == d) {
            return dp[i][j] = 1 + solve(i + 1, j + 1, s, p, dp);
        } else {
            int left = solve(i + 1, j, s, p, dp);
            int right = solve(i, j + 1, s, p, dp);
            return dp[i][j] = Math.max(left, right);
        }
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(0, 0, text1, text2, dp);
    }
    public static void main(String[] args) {
        String s = "ancde";
        String d = "bdc";
        int count = longestCommonSubsequence(s, d);
        System.out.println(count);
    }
}
