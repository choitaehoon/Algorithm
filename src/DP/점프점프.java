package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class 점프점프 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int[] jump = new int[givenNumber+1];
        for (int i = 1; i < givenNumber; ++i)
            jump[i] = Integer.parseInt(token.nextToken());

        System.out.println(minimumJump(givenNumber, jump));
    }

    private static int minimumJump(int givenNumber, int[] jump) {
        int[] dp = new int[givenNumber+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int width = 1; width <= givenNumber; ++width) {
            if (dp[width] != Integer.MAX_VALUE) {
                int jumpNumber = jump[width];

                for (int location = 1; location <= jumpNumber; ++location) {
                    if (width + location > givenNumber)
                        continue;

                    dp[width + location] = Math.min(dp[width] + 1, dp[width + location]);
                }
            }
        }

        return dp[givenNumber] == Integer.MAX_VALUE ? -1 : dp[givenNumber];
    }

}
