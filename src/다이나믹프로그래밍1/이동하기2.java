package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이동하기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int x = Integer.parseInt(token.nextToken());
        int y = Integer.parseInt(token.nextToken());
        int[][] array = new int[x + 1][y + 1];
        int[][] dp = new int[x + 1][y + 1];

        for (int i = 1; i <= x; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
            for (int k = 1; k <= y; ++k) {
                array[i][k] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = 1; i <= x; ++i) {
            for (int k = 1; k <= y; ++k) {
                dp[i][k] = Math.max(dp[i - 1][k], Math.max(dp[i][k - 1], dp[i - 1][k - 1])) + array[i][k];
            }
        }

        System.out.println(dp[x][y]);
    }

}
