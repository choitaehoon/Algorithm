package 알고리즘기초.다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int card = Integer.parseInt(buffer.readLine());

        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int count = token.countTokens();
        int[] array = new int[card+1];
        int[] maxArray = new int[card+1];

        for (int i=1; i<=count; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        for (int i=1; i<=card; ++i) {
            int max = 0;

            for (int j=1; j<=i; ++j)
                max= Math.max(max, array[j] + maxArray[i - j]);

            maxArray[i] = max;
        }

        System.out.println(maxArray[card]);
    }

}
