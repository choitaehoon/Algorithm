package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int[][] array = new int[n + 1][n + 1];
        int[][][] dp = new int[n + 1][n + 1][3];

        for (int i = 1; i <= n; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int k = 1; k <= n; ++k) {
                array[i][k] = Integer.parseInt(token.nextToken());
            }
        }

        dp[1][2][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int k = 1; k <= n; ++k) {
                if (array[i][k] == 1)
                    continue;

                dp[i][k][0] += dp[i][k - 1][0] + dp[i][k - 1][2];
                dp[i][k][1] += dp[i - 1][k][1] + dp[i - 1][k][2];

                if (array[i - 1][k] == 0 && array[i][k - 1] == 0)
                    dp[i][k][2] += dp[i - 1][k - 1][0] + dp[i - 1][k - 1][1] + dp[i - 1][k - 1][2];
            }
        }

        System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);
    }

}
