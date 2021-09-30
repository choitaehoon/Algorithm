package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커3 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < testCase; ++i) {
            int col = Integer.parseInt(buffer.readLine());
            int[][] array = new int[2][100_001];

            StringTokenizer token1 = new StringTokenizer(buffer.readLine());
            for (int k = 0; k < col; ++k) {
                array[0][k] = Integer.parseInt(token1.nextToken());
            }

            StringTokenizer token2 = new StringTokenizer(buffer.readLine());
            for (int k = 0; k < col; ++k) {
                array[1][k] = Integer.parseInt(token2.nextToken());
            }

            solutionGo(col, array);
        }

    }

    private static void solutionGo(int col, int[][] array) {
        int[][] dp = new int[2][100_001];

        dp[0][0] = array[0][0];
        dp[1][0] = array[1][0];
        dp[0][1] = dp[1][0] + array[0][1];
        dp[1][1] = dp[0][0] + array[1][1];

        for (int i = 2; i < col; ++i) {
            dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + array[0][i];
            dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + array[1][i];
        }

        System.out.println(Math.max(dp[0][col - 1], dp[1][col - 1]));
    }

}
