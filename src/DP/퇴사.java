package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퇴사 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        int[][] advice = new int[givenNumber+1][2];

        for (int i = 1; i <= givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            advice[i][0] = Integer.parseInt(token.nextToken());
            advice[i][1] = Integer.parseInt(token.nextToken());
        }

        System.out.println(solution(givenNumber, advice));
    }

    private static int solution(int givenNumber, int[][] advice) {
        int[] dp = new int[givenNumber+2];

        for (int i = givenNumber; i >= 1; --i) {
            int nextDay = advice[i][0] + i;

            if (nextDay - 1 > givenNumber) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], dp[nextDay] + advice[i][1]);
            }
        }

        return dp[1];
    }

}
