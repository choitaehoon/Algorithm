package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이동하기1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(nm.nextToken());
        int m = Integer.parseInt(nm.nextToken());
        int[][] array = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int j = 1; j <= m; ++j) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                dp[i][j] = Math.max(dp[i-1][j-1],
                        Math.max(dp[i-1][j], dp[i][j-1])) + array[i][j];
            }
        }

        System.out.println(dp[n][m]);
    }



}
