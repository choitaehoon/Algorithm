package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합분해 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        int[][] dp = new int[201][201];
        dp[0][0] = 1;
        for (int i = 1; i <= k; ++i)
            dp[0][i] = 1;

        for (int i = 1; i <= n; ++i) {
            for (int m = 1; m <= k; ++m)
                dp[i][m] = (dp[i][m - 1] + dp[i - 1][m]) % 1_000_000_000;
        }

        System.out.println(dp[n][k]);
    }

}
