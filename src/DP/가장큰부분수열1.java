package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장큰부분수열1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int[] array = new int[number];
        int[] dp = new int[number];

        for (int i = 0; i < number; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        int max = 0;
        for (int i = 0; i < number; ++i) {
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