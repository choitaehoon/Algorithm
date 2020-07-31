package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 리조트 {

    static Map<Integer, Boolean> noResort = new HashMap<>();
    static int[][] price;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        price = new int[n + 1][n + 1];

        if (m > 0) {
            StringTokenizer noTravel = new StringTokenizer(buffer.readLine());
            for (int i = 0; i < m; ++i) {
                noResort.put(Integer.parseInt(noTravel.nextToken()), true);
            }
        }

        for (int[] value : price)
            Arrays.fill(value, Integer.MAX_VALUE);

        int min = minCost(1, 0);
        System.out.println(Arrays.deepToString(price));
        System.out.println(min);
    }

    private static int minCost(int day, int coupon) {
        if (day >= n + 1) return 0;

        if (price[day][coupon] != Integer.MAX_VALUE) return price[day][coupon];

        if (noResort.containsKey(day)) {
            price[day][coupon] = minCost(day + 1, coupon);
        } else {
            price[day][coupon] = Math.min(price[day][coupon], minCost(day + 1, coupon) + 10_000);
            price[day][coupon] = Math.min(price[day][coupon], minCost(day + 3, coupon + 1) + 25_000);
            price[day][coupon] = Math.min(price[day][coupon], minCost(day + 5, coupon + 2) + 37_000);

            if (coupon >= 3)
                price[day][coupon] = Math.min(price[day][coupon], minCost(day + 1, coupon - 3));
        }

        return price[day][coupon];
     }

}