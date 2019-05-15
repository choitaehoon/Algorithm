package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int givenNumber = Integer.parseInt(buffer.readLine());
        int[][] array = new int[givenNumber][givenNumber];
        long[][] dp = new long[givenNumber][givenNumber];

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int j=0; j<givenNumber; ++j)
                array[i][j] = Integer.parseInt(token.nextToken());
        }

        dp[0][0] = 1;

        for (int i=0; i<givenNumber; ++i)
            for (int j=0; j<givenNumber; ++j) {
                if (dp[i][j] == 0 || (i == givenNumber-1 && j == givenNumber-1))
                    continue;

                int xMove = i + array[i][j];
                int yMove = j + array[i][j];

                if (xMove < givenNumber)
                    dp[xMove][j] += dp[i][j];
                if (yMove < givenNumber)
                    dp[i][yMove] += dp[i][j];

            }

        System.out.println(dp[givenNumber-1][givenNumber-1]);
    }

}