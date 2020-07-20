package DP;

public class 타일장식물 {

    public static void main(String[] args) {
        System.out.println(solution(
                80
        ));
    }

    public static long solution(int N) {

        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; ++i)
            dp[i] = dp[i - 1] + dp[i - 2];

        return (dp[N - 1] * 2) + (dp[N] * 2);
    }

}
