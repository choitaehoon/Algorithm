package KOI2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

//TODO 다시 풀어보기
@SuppressWarnings("Duplicates")
public class 서울에서경산까지 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token1 = new StringTokenizer(buffer.readLine());

        Stack<Integer> stack = new Stack<>();

        int circle = Integer.parseInt(token1.nextToken());
        int time = Integer.parseInt(token1.nextToken());
        int[][] dp = new int[circle][4];

        StringTokenizer token2 = new StringTokenizer(buffer.readLine());
        for (int i=0; i<4; ++i)
            dp[0][i] = Integer.parseInt(token2.nextToken());

        for (int i=1; i<circle; ++i) {
            StringTokenizer token3 = new StringTokenizer(buffer.readLine());

            int walkTime = Integer.parseInt(token3.nextToken());
            int walkPrice = Integer.parseInt(token3.nextToken());

            int cycleTime = Integer.parseInt(token3.nextToken());
            int cyclePrice = Integer.parseInt(token3.nextToken());

            if (dp[i-1][0] + walkTime <= time) {
                dp[i][0] = dp[i-1][0] + walkTime;
                dp[i][1] = dp[i-1][1] + walkPrice;
            }
            else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1];
            }

             if (dp[i-1][0] + cycleTime <= time){
                dp[i][2] = dp[i-1][0] + cycleTime;
                dp[i][3] = dp[i-1][1] + cyclePrice;
            }
             else {
                 dp[i][2] = dp[i-1][2];
                 dp[i][3] = dp[i-1][3];
             }

            if (dp[i-1][2] + walkTime <= time  && dp[i][3] < dp[i-1][3] + walkPrice){
                    dp[i][3] = dp[i-1][3] + walkPrice;
                    dp[i][2] = dp[i-1][2] + walkTime;
            }
            if (dp[i-1][2] + cycleTime <= time && dp[i][3] < dp[i-1][3] + cyclePrice) {
                    dp[i][3] = dp[i-1][3] + cyclePrice;
                    dp[i][2] = dp[i-1][2] + cycleTime;
            }

        }

        System.out.println(Arrays.deepToString(dp));
        System.out.println(Math.max(dp[circle-1][1], dp[circle-1][3]));
    }
}
