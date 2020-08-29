package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기 {

    static int[] dp = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < givenNumber; ++i) {
            int num = Integer.parseInt(buffer.readLine());

            dp[1] = 1; dp[2] = 2; dp[3] = 4; dp[4] = 7;

            for (int k = 5; k <= num; ++k) {
                dp[k] = dp[k - 3] + dp[k - 2] + dp[k - 1];
            }

            System.out.println(dp[num]);
        }
    }


}
