package KOI2016.중등부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 주유소 {

    static long[] dist = new long[100000];
    static long[] price = new long[100000];
    static long[] dp = new long[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.parseInt(buffer.readLine());

        StringTokenizer tokenDist = new StringTokenizer(buffer.readLine());
        int distLength = tokenDist.countTokens();
        for (int i=0; i<distLength; ++i)
            dist[i] = Integer.parseInt(tokenDist.nextToken());

        StringTokenizer tokenPrice = new StringTokenizer(buffer.readLine());
        int priceLength = tokenPrice.countTokens();
        for (int i=0; i<priceLength; ++i)
            price[i] = Integer.parseInt(tokenPrice.nextToken());

        dp[0] = price[0] * dist[0];
        long min = price[0];

        for (int i=1; i<city; ++i) {
            if (price[i] < min)
                min = price[i];
            dp[i] = dp[i-1] + min * dist[i];
        }

        System.out.println(dp[city-1]);
    }
}
