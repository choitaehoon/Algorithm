package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < givenNumber; ++i) {
            int givenMoney = Integer.parseInt(buffer.readLine());
            int[] money = new int[givenMoney + 1];
            StringTokenizer token = new StringTokenizer(buffer.readLine());

            for (int z = 1; z <= givenMoney; ++z)
                money[z] = Integer.parseInt(token.nextToken());
ㅎ
            int reachMoney = Integer.parseInt(buffer.readLine());
            int[] dp = new int[reachMoney + 1];
            dp[0] = 1;

            for (int z = 1; z <= givenMoney; ++z)
                for (int k = money[z]; k <= reachMoney; ++k)
                    dp[k] += dp[k - money[z]];

            System.out.println(dp[reachMoney]);
        }

    }

}