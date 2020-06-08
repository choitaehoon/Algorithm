package solve;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        System.out.println(maxProfitOne(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //Time complexity O(N^2)
    public static int maxProfitOne(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length; ++i) {
            for (int j = i + 1; j < prices.length; ++j) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }

        return max;
    }

    //Time complexity O(N)
    public static int maxProfitTwo(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > max)
                max = prices[i] - minPrice;
        }

        return max;
    }

}
