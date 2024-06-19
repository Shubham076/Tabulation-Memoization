import java.util.ArrayList;
import java.util.Arrays;

public class ballonBurst {
    public static int solve(int i, int j, ArrayList<Integer> arr, int[][] dp) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) return dp[i][j];
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int left = solve(i, k - 1, arr, dp);
            int right = solve(k + 1, j, arr, dp);
            int cur = arr.get(i - 1) * arr.get(k) * arr.get(j + 1);
            max = Math.max(max, left + cur + right);
        }
        return dp[i][j] = max;
    }

    public static int maxCoins(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        for (int val: nums) {
            arr.add(val);
        }
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int[] a: dp) {
            Arrays.fill(a, -1);
        }
        arr.add(1);
        return solve(1, nums.length, arr, dp);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 8};
        System.out.println(maxCoins(arr));
    }
}
