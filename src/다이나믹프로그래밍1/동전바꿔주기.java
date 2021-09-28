package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전바꿔주기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int count = Integer.parseInt(buffer.readLine());
        Bank[] banks = new Bank[count];
        int[] dp= new int[n + 1];

        for (int i = 0; i < count; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int price = Integer.parseInt(token.nextToken());
            int num = Integer.parseInt(token.nextToken());
            banks[i] = new Bank(price, num);
        }

        dp[0] = 1;
        for (int i = 0; i < count; ++i) {
            Bank bank = banks[i];
            int nowPrice = bank.price;
            int nowCount = bank.count;

            for (int totalSum = n; totalSum >= 0; --totalSum) {
                for (int k = 1; k <= nowCount && totalSum - nowPrice * k >= 0; ++k) {
                    dp[totalSum] += dp[totalSum - nowPrice * k];
                }
            }

        }

        System.out.println(dp[n]);
    }

}

class Bank {

    int price;
    int count;

    public Bank(int price, int count) {
        this.price = price;
        this.count = count;
    }

}