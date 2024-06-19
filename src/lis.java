public class lis {
    public static int solve(int idx, int pidx, int[] arr) {
        if (idx == arr.length) {
            return 0;
        }

        // 2 choices
        // don't include
        int len = solve(idx + 1, pidx, arr);

        if (pidx == -1 || arr[idx] > arr[pidx]) {
            len = Math.max(len, 1 + solve(idx + 1, idx, arr));
        }

        return len;
    }
    public static void main(String[] args) {
        int[] arr = {7,7,7,7,7,7,7};
        System.out.println(solve(0, -1, arr));
    }
}
