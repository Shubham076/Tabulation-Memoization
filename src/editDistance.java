//leetcode 72
public class editDistance {
/*

        h o r s e
        r o s

 choice 1: replace h with r, remaining string becomes
        r   o r s e     =>  (i + 1, j + 1)
        r   o s

choice2: delete h remaining string becomes
        h   o r s e   =>   (i + 1, j)
            r o s

choice3 insert r then remaining string becomes,  i at h and j at r
        r    h o r s e  => i is still at same position => (i , j + 1)
        r    o s
 */
    public static int solve(int i, int j, String s, String p) {

        // add operation
        if (i == s.length()) {
            return p.length() - j;
        }

        // delete operation
        if (j == p.length()) {
            return s.length() - i;
        }

        char c = s.charAt(i);
        char d = p.charAt(j);

        if (c == d) {
            return solve(i + 1, j + 1, s, p);
        } else {
            int replace = solve(i + 1, j + 1, s, p);
            int add = solve(i, j + 1, s, p);
            int delete = solve(i + 1, j, s, p);
            return 1 + Math.min(replace, Math.min(add, delete));
        }
    }

    public static int tabulation(String s, String p) {
        int m = s.length();
        int n = p.length();

        int[][] dp =  new int[m + 1][n + 1];

        for (int i = m ; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m) {
                    dp[i][j] = n - j;
                } else if (j == n) {
                    dp[i][j] = m - i;
                } else {
                    char c =  s.charAt(i);
                    char d =  p.charAt(j);
                    if (c == d) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        int add = dp[i][j + 1];
                        int delete = dp[i + 1][j];
                        int replace = dp[i + 1][j + 1];
                        dp[i][j] = 1 + Math.min(replace, Math.min(add, delete));
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static int minDistance(String word1, String word2) {
        return solve(0, 0, word1, word2);
    }
    public static void main(String[] args) {
        String s = "horse";
        String d = "ros";
        int ans = minDistance(s, d);
        System.out.println(ans);
    }
}
