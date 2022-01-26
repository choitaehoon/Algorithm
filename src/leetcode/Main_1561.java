package leetcode;

import java.util.Arrays;

public class Main_1561 {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int maxCoins = 0;
        for (int i = piles.length / 3, pilesLen = piles.length; i < pilesLen ; i += 2){
            maxCoins += piles[i];
        }

        return maxCoins;
    }

}
