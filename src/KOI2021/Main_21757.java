package KOI2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21757 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int tokenSize = token.countTokens();
        long[] array = new long[n + 1];

        for (int i = 0; i < tokenSize; ++i) {
            array[i + 1] = Long.parseLong(token.nextToken());
        }

        solution(n, array);
    }

    private static void solution(int n, long[] array) {
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            sum[i] += sum[i - 1] + array[i];
        }

        long query = sum[n] / 4;

        long[][] dp = new long[100_001][4];
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i][0] = 1;
            for (int k = 1; k <= 3; ++k) {
                dp[i][k] = dp[i - 1][k];
                if (query * k == sum[i])
                    dp[i][k] += dp[i - 1][k - 1];
            }
        }

        System.out.println(dp[n - 1][3]);
    }

}
