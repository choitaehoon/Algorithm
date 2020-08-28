package medium;

public class Main343 {

    public static void main(String[] args) {

    }

    public static int integerBreak(int n) {
        int[] dp = new int[59];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int k = 1; k < i; ++k) {
                dp[i] = Math.max(dp[i], Math.max(dp[k], k) * Math.max(dp[i - k], i - k));
            }
        }

        return dp[n];
    }

}
