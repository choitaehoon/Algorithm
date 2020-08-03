package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상자넣기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int[] box = new int[givenNumber];
        int[] dp = new int[givenNumber];
        int max = 0;

        for (int i = 0; i < givenNumber; ++i)
            box[i] = Integer.parseInt(token.nextToken());

        for (int i = 0; i < givenNumber; ++i) {
            dp[i] = 1;

            for (int k = 0; k < i; ++k) {
                if (box[i] > box[k] && dp[k] + 1 > dp[i])
                   dp[i] = dp[k] + 1;
            }

            if (max < dp[i])
                max = dp[i];
        }

        System.out.println(max);
    }

}
