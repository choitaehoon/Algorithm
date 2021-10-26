package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파스칼의삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int line = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        int[][] dp = new int[31][31];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;

        for (int row = 3; row <= line; ++row) {
            for (int col = 1; col <= row; ++col) {
                if (col == 1 || col == row) {
                    dp[row][col] = 1;
                } else {
                    dp[row][col] = dp[row - 1][col - 1] + dp[row - 1][col];
                }
            }
        }

        System.out.println(dp[line][k]);
    }

}
