package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB거리1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        int[][] dp = new int[n + 1][3];
        int[][] array = new int[n + 1][3];

        for (int i = 1; i <= n; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c= Integer.parseInt(token.nextToken());

            array[i][0] = a; array[i][1] = b; array[i][2] = c;
        }

        for (int i = 1; i <= n; ++i) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + array[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + array[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + array[i][2];
        }

        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
    }

}
