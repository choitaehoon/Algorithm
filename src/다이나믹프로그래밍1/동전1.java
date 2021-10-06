package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        int[] value = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; ++i) {
            value[i] = Integer.parseInt(buffer.readLine());
        }

        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int m = 0; m <= k; ++m) {
                if (m - value[i] >= 0) {
                    dp[m] += dp[m - value[i]];
                }
            }
        }

        System.out.println(dp[k]);
    }

}
