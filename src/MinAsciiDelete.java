// leetcode 712
public class MinAsciiDelete {

    public static int solve(int i, int j, String a, String b, int[][] dp) {
        if (i == a.length() && j == b.length()) {
            return 0;
        }

        if (i == a.length()) {
            int sum = 0;
            while (j < b.length()) {
                sum += b.charAt(j++);
            }
            return sum;
        }

        if  (j == b.length()) {
            int sum = 0;
            while (i < a.length()) {
                sum += a.charAt(i++);
            }
            return sum;
        }

        if (dp[i][j] > 0) return dp[i][j];
        char c = a.charAt(i);
        char d = b.charAt(j);

        if (c == d) {
            // both are equal move forward
            return dp[i][j] = solve(i + 1, j + 1, a, b, dp);
        } else {
            // we have a choice either delete c or d
            int v1 = c + solve(i + 1, j, a, b, dp);
            int v2 = d + solve(i, j + 1, a, b, dp);
            return dp[i][j] = Math.min(v1, v2);
        }
    }
    public static int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        return solve(0, 0, s1, s2, dp);
    }

    public static void main(String[] args) {
        String a = "sea";
        String b = "eat";
        int ans = minimumDeleteSum(a, b);
        System.out.println(ans);
    }
}
