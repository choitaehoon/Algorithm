package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연속합 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int[] array = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

}
