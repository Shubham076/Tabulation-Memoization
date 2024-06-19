public class WildCardMatching {

    public static boolean solve(int i, int j, String s, String p) {
        if (i == 0 && j == 0) return true;
        if (j == 0 && i > 0) return false;
        if (i == 0 && j > 0) {
            for (int jj = 1; jj <= j; jj++) {
                if (p.charAt(jj - 1) != '*') return false;
            }
            return true;
        }

        char c = s.charAt(i - 1);
        char d = p.charAt(j - 1);

        if (c == d || d == '?') {
            return solve(i - 1, j - 1, s, p);
        }

        if (d == '*') {
            return solve(i, j - 1, s, p) | solve(i - 1, j, s, p);
        }

        return false;
    }

    public static boolean tabulation(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j <= m; j++) {
            boolean flag = true;
            for (int jj = 1; jj < j; jj++) {
                if (p.charAt(jj - 1) != '*') {
                    flag =  false;
                    break;
                }
            }
            dp[0][j] = flag;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c = s.charAt(i - 1);
                char d = p.charAt(j - 1);

                if (c == d || d == '?') {
                    dp[i][j] =  dp[i - 1][j- 1];
                } else if (d == '*') {
                    dp[i][j] =  dp[i][j - 1] | dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        return solve(n, m, s, p);
    }
    public static void main(String[] args) {
        String s = "mississippi";
        String p = "m??*ss*?i*pi";
        System.out.println(isMatch(s, p));
    }
}
