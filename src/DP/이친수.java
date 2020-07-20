package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        long[] dp = new long[givenNumber + 1];

        dp[1] = 1;
        for (int i = 2; i <= givenNumber; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[givenNumber]);
    }

}
