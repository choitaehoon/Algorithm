package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 병사배치하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int[] array = new int[n];
        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 0; i < n; ++i) {
            dp[i] = 1;

            for (int k = 0; k < i; ++k) {
                if (array[k] > array[i] && dp[k] + 1 > dp[i])
                    dp[i] = dp[k] + 1;
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);
    }

}
