package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기 {

    public static void main(String[] args) throws IOException {
        inputLeftRight();
    }

    private static void inputLeftRight() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(buffer.readLine());

        for (int i=0; i<n; ++i ) {
            StringTokenizer token =
                    new StringTokenizer(buffer.readLine());

            int left = Integer.parseInt(token.nextToken());
            int right = Integer.parseInt(token.nextToken());
            int[][] dp = new int[31][31];

            int r = recursive(left, right, dp);
            System.out.println(r);
        }
    }

    private static int recursive(int left, int right, int[][] dp) {

        if (left == right || left == 0) {
            return 1;
        }

        if (dp[left][right] > 0) return dp[left][right];

        return dp[left][right] = recursive(left - 1, right - 1, dp) + recursive(left, right - 1, dp);

    }


}
