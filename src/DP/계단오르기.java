package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 계단오르기 {

    static int[] stairs;
    static int givenStairs;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenStairs = Integer.parseInt(buffer.readLine());
        stairs = new int[givenStairs];

        for (int i = 0; i < givenStairs; ++i) {
            stairs[i] = Integer.parseInt(buffer.readLine());
        }

        System.out.println(solution());
    }

    private static int solution() {
        int[] dpStairs = new int[givenStairs];

        if (givenStairs == 1) {
            return stairs[0];
        } else if (givenStairs == 2) {
            return Math.max(stairs[0] + stairs[1], stairs[1]);
        } else if (givenStairs == 3) {
            return Math.max(dpStairs[0], dpStairs[1]) + stairs[2];
        }

        dpStairs[0] = stairs[0];
        dpStairs[1] = Math.max(stairs[0] + stairs[1], stairs[1]);
        dpStairs[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

        for (int i = 3; i < givenStairs; ++i) {
            dpStairs[i] = Math.max(dpStairs[i - 2] + stairs[i],  dpStairs[i - 3] + stairs[i - 1] + stairs[i]);
        }

        return dpStairs[givenStairs - 1];
    }


}
