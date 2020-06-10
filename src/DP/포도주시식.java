package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 포도주시식 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        int[] wine = new int[givenNumber];

        for (int i = 0; i < givenNumber; ++i)
            wine[i] = Integer.parseInt(buffer.readLine());

        System.out.println(solution(givenNumber, wine));
    }

    private static int solution(int givenNumber, int[] wine) {

        int[] dp = new int[givenNumber];
        if (1 <= givenNumber)
            dp[0] = wine[0];
        if (2 <= givenNumber)
            dp[1] = wine[1] + wine[0];
        if (3 <= givenNumber)
            dp[2] = Math.max(dp[1], Math.max(dp[0] + wine[2], wine[1] + wine[2]));

        for (int i = 3; i < givenNumber; ++i) {
            dp[i] = Math.max(dp[i-1],
                    Math.max(dp[i-3] + wine[i-1] + wine[i], dp[i-2] + wine[i])
            );
        }

        return dp[givenNumber-1];
    }

}
