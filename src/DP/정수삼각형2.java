package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 정수삼각형2 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(buffer.readLine());
        int[][] array = new int[num][num];
        int[][] dp = new int[num][num];

        for (int i = 0; i < num; ++i) {
            String[] temp = buffer.readLine().split(" ");
            for (int k = 0; k < temp.length; ++k) {
                array[i][k] = Integer.parseInt(temp[k]);
            }
        }

        dp[0][0] = array[0][0];

        for (int i = 1; i < num; ++i) {
            for (int k = 0; k < i + 1; ++k) {
                if (k == 0)
                    dp[i][0] = dp[i - 1][0] + array[i][0];
                else if (k == i)
                    dp[i][k] = dp[i - 1][k - 1] + array[i][k];
                else
                    dp[i][k] = Math.max(dp[i - 1][k - 1], dp[i - 1][k]) + array[i][k];
            }
        }

        int max = 0;
        for (int i = 0; i < num; ++i)
            for (int k = 0; k < num; ++k)
                max = Math.max(dp[i][k], max);

        System.out.println(max);
    }

}
