package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 점프점프 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int[] array = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 1; i <= n; ++i) {

            if (dp[i] != Integer.MAX_VALUE) {
                for (int location = 1; location <= array[i]; ++location) {
                    if (i + location > n)
                        continue;

                    dp[i + location] = Math.min(dp[i] + 1, dp[i + location]);
                }
            }

        }

        System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
    }

}
