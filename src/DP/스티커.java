package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커 {

    public static void main(String[] args) throws IOException {
        inputArray();
    }

    private static void inputArray() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        for (int i=0; i<n; ++i) {
            int len = Integer.parseInt(buffer.readLine());

            int[][] array = new int[2][len];
            StringTokenizer token1 =
                    new StringTokenizer(buffer.readLine());
            StringTokenizer token2 =
                    new StringTokenizer(buffer.readLine());

            for (int z=0; z<len; ++z) {
                array[0][z] = Integer.parseInt(token1.nextToken());
            }

            for (int z=0; z<len; ++z) {
                array[1][z] = Integer.parseInt(token2.nextToken());
            }

            searchMax(array);
        }

    }

    private static void searchMax(int[][] array) {
        int[][] dp = new int[2][array[0].length];

        dp[0][0] = array[0][0];
        dp[1][0] = array[1][0];
        dp[0][1] = dp[1][0] + array[0][1];
        dp[1][1] = dp[0][0] + array[1][1];

        for (int i=2; i<array[0].length; ++i) {
            dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + array[0][i];
            dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + array[1][i];
        }

        System.out.println(
                Math.max(dp[0][array[0].length-1], dp[1][array[0].length-1])
        );
    }


}
