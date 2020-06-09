package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 욕심쟁이판다1 {

    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static int[][] dp;
    static int[][] bamboo;
    static int max;
    static int givenNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        bamboo = new int[givenNumber][givenNumber];
        dp = new int[givenNumber][givenNumber];

        for (int width = 0; width < givenNumber; ++width) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int vertical = 0; vertical < givenNumber; ++vertical) {
                bamboo[width][vertical] = Integer.parseInt(token.nextToken());
            }
        }

        for (int width = 0; width < givenNumber; ++width) {
            for (int vertical = 0; vertical < givenNumber; ++vertical) {
                max = Math.max(max, survival(width, vertical));
            }
        }

        System.out.println(max);
    }

    private static int survival(int width, int vertical) {
        if (dp[width][vertical] != 0)
            return dp[width][vertical];

        dp[width][vertical] = 1;

        for (int i = 0; i < 4; ++i) {
            int xGo = width + xMove[i];
            int yGo = vertical + yMove[i];

            if (xGo < 0 || xGo >= givenNumber || yGo < 0 || yGo >= givenNumber )
                continue;

            if (bamboo[width][vertical] < bamboo[xGo][yGo])
                dp[width][vertical] = Math.max(dp[width][vertical], survival(xGo, yGo) + 1);
        }

        return dp[width][vertical];
    }

}
