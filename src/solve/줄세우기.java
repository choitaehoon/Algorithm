package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 줄세우기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        int[] array = new int[givenNumber+1];
        int[] dp = new int[givenNumber+1];
        int max = 0;

        for (int i=1; i<=givenNumber; ++i)
            array[i] = Integer.parseInt(buffer.readLine());

        for (int i=1; i<=givenNumber; ++i) {
            dp[i] = 1;

            for (int j=1; j<i; ++j) {
                if (array[j] < array[i] && dp[i] <= dp[j])
                    dp[i]++;
            }

            if (max < dp[i]) max = dp[i];
        }

        System.out.println(givenNumber - max);
    }
}
