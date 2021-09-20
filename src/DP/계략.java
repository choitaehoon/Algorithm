package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 계략 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int[] array = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; ++i) {
            int num = Integer.parseInt(token.nextToken());
            array[i] = num;
        }

        int max = 0;
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;

            for (int k = 0; k < i; ++k) {
                if (array[k] < array[i]) {
                    dp[i] = Math.max(dp[k] + 1, dp[i]);
                }
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

}
