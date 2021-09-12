package leetcode.greedy;

import java.util.Arrays;

public class Main_1561 {

    public int maxCoins(int[] piles) {
        int sum = 0;
        int start = 0;
        int end = piles.length - 2;
        Arrays.sort(piles);

        while(start < end) {
            sum += piles[end];

            ++start;
            end -= 2;
        }

        return sum;
    }
}
