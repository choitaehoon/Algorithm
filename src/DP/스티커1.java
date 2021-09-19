package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < input; ++i) {
            int size = Integer.parseInt(buffer.readLine());
            int[][] array = new int[2][size];
            int[][] dp = new int[2][size];

            StringTokenizer up = new StringTokenizer(buffer.readLine());
            StringTokenizer down = new StringTokenizer(buffer.readLine());

            for (int k = 0; k < size; ++k) {
                array[0][k] = Integer.parseInt(up.nextToken());
                array[1][k] = Integer.parseInt(down.nextToken());
            }

            solution(array, dp, size);
        }
    }

    private static void solution(int[][] array, int[][] dp, int size) {
        if (size == 1) {
            dp[0][0] = array[0][0];
            dp[1][0] = array[1][0];

            System.out.println(Math.max(dp[0][0], dp[1][0]));
        } else if (size == 2) {
            dp[0][0] = array[0][0];
            dp[1][0] = array[1][0];
            dp[0][1] = dp[1][0] + array[0][1];
            dp[1][1] = dp[0][0] + array[1][1];

            System.out.println(Math.max(dp[0][1], dp[1][1]));
        } else {
            dp[0][0] = array[0][0];
            dp[1][0] = array[1][0];
            dp[0][1] = dp[1][0] + array[0][1];
            dp[1][1] = dp[0][0] + array[1][1];

            for (int i = 2; i < size; ++i) {
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + array[1][i];
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + array[0][i];
            }

            System.out.println(Math.max(dp[0][size - 1], dp[1][size - 1]));
        }
    }

}
