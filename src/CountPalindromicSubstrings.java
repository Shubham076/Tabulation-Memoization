public class CountPalindromicSubstrings {

    public static boolean isPalindrome(int i, int j, String s, boolean[][] dp) {
        if (i >= j) return true;
        if (dp[i][j]) return dp[i][j];
        if (s.charAt(i) != s.charAt(j)) return dp[i][j] = false;

        return dp[i][j] = isPalindrome(i + 1, j - 1, s, dp);
    }

    public static int recursion(String s) {
        if (s.length() == 1) return 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                ans += isPalindrome(i, j, s, dp) ? 1 : 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ab";
        int count = recursion(s);
        System.out.println("Recursion: " + count);
    }
}
