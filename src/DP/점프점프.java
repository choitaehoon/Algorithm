package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class 점프점프 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        int[] jump = Stream.of(buffer.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(minimumJumpTwo(givenNumber, jump));
    }

    private static int minimumJumpTwo(int givenNumber, int[] jump) {
        int[] dp = new int[givenNumber];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < givenNumber; ++i) {
            if (dp[i] != Integer.MAX_VALUE) {
                int jumpNumber = jump[i];

                for (int j = 1; j <= jumpNumber; ++j) {
                    if (i + j >= givenNumber)
                        continue;

                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }

        return dp[givenNumber-1] == Integer.MAX_VALUE ? -1 : dp[givenNumber-1];
    }

}
