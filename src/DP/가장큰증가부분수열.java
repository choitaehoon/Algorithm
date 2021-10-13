package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰증가부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        int max = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = array[i];

            for (int k = 0; k < i; ++k) {
                if (array[k] < array[i]) {
                    dp[i] = Math.max(dp[i], dp[k] + array[i]);
                }
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

}
