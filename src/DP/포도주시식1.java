package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 포도주시식1 {

    static int[] grape;

    public static void main(String[] args) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            int givenNumber = Integer.parseInt(buffer.readLine());
            grape = new int[givenNumber];

            for (int i = 0; i < givenNumber; ++i)
                grape[i] = Integer.parseInt(buffer.readLine());

            System.out.println(maxGrapeCount(givenNumber));
        }

    }

    private static int maxGrapeCount(int givenNumber) {
        if(givenNumber == 1) {
            return grape[0];
        } else if (givenNumber == 2) {
            return grape[0] + grape[1];
        } else if (givenNumber == 3) {
            return Math.max(grape[0] + grape[2], Math.max(grape[1] + grape[2], grape[0] + grape[1]));
        }

        int[] dp = new int[givenNumber];
        dp[0] = grape[0];
        dp[1] = grape[0] + grape[1];
        dp[2] = Math.max(grape[0] + grape[2], Math.max(grape[1] + grape[2], grape[0] + grape[1]));

        for (int i = 3; i < givenNumber; ++i) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + grape[i - 1] + grape[i], dp[i - 2] + grape[i]));
        }

        return dp[givenNumber - 1];
    }

}
