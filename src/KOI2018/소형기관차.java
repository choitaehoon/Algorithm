package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소형기관차 {

    static int[] sumPerson;
    static int[] givenArray;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int m = Integer.parseInt(buffer.readLine());

        sumPerson = new int[givenNumber+1];
        givenArray = new int[givenNumber+1];
        dp = new int[givenNumber+1][4];

        for (int i=1; i<=givenNumber; ++i) {
            givenArray[i] = Integer.parseInt(token.nextToken());
            sumPerson[i] = sumPerson[i-1]+givenArray[i];
        }

        for (int i=1; i<=3; ++i)
            for (int j=i*m; j<=givenNumber; ++j)
                dp[j][i] =Math.max(dp[j-1][i], dp[j-m][i-1] + (sumPerson[j]-sumPerson[j-m]));

        System.out.println(dp[givenNumber][3]);

    }
}
