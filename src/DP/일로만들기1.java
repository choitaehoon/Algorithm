package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        int[] dp = new int[givenNumber + 1];
        dp[1] = 0;

        for (int i = 2; i <= givenNumber; ++i) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        }

        System.out.println(dp[givenNumber]);
    }


}