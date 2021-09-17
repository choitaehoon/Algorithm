package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 포도주시식2 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int[] array = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; ++i) {
            int num = Integer.parseInt(buffer.readLine());
            array[i] = num;
        }

        if (n == 1) {
            System.out.println(array[0]);
        } else if (n == 2) {
            System.out.println(array[0] + array[1]);
        } else if (n == 3) {
            System.out.println(Math.max(array[0] + array[2], Math.max(array[1] + array[2], array[0] + array[1])));
        } else {
            dp[0] = array[0];
            dp[1] = array[0] + array[1];
            dp[2] = Math.max(array[0] + array[2], Math.max(array[1] + array[2], array[0] + array[1]));

            for (int i = 3; i < n; ++i) {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + array[i - 1] + array[i], dp[i - 2] + array[i]));
            }

            System.out.println(dp[n - 1]);
        }

    }

}
