package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        int[][] triangle = new int[givenNumber][givenNumber];
        int[][] dp = new int[givenNumber][givenNumber];

        for (int width = 0; width < givenNumber; ++width) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int verticalLength = token.countTokens();

            for (int vertical = 0; vertical < verticalLength; ++vertical)
                triangle[width][vertical] = Integer.parseInt(token.nextToken());
        }

        System.out.println(solution(givenNumber, triangle, dp));
    }

    private static int solution(int givenNumber, int[][] triangle, int[][] dp) {
        if (givenNumber == 1)
            return triangle[0][0];

        int maxDp = 0;
        dp[0][0] = triangle[0][0];

        for (int width = 1; width < givenNumber; ++width) {

            for (int vertical = 0; vertical <= width; ++vertical) {
                if (vertical == 0)
                    dp[width][vertical] = dp[width-1][0] + triangle[width][vertical];
                else if (vertical == width)
                    dp[width][vertical] = dp[width-1][vertical-1] + triangle[width][vertical];
                else
                    dp[width][vertical] = Math.max(dp[width-1][vertical-1], dp[width-1][vertical]) + triangle[width][vertical];

                maxDp = Math.max(maxDp, dp[width][vertical]);
            }
        }

        return maxDp;
    }

}
