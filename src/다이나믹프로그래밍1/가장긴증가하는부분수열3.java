package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열3 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int[] array = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        for (int i = 0; i < n; ++i) {
            dp[i] = 1;

            for (int k = 0; k < i; ++k)
                if (array[i] > array[k])
                    dp[i] = Math.max(dp[i], dp[k] + 1);
        }

        int max = 0;
        for (int i = 0; i < n; ++i)
            max = Math.max(dp[i], max);

        System.out.println(max);
    }

}
