package leetcode.sliding.window;

public class Main_643 {

    public static void main(String[] args) {

    }

    public double findMaxAverage(int[] nums, int k) {

        int start = 0;
        double sum = 0;
        double max = -10001;

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];

            if (i >= k - 1) {
                max = Math.max(max, sum / (double)(k));
                sum -= (double)(nums[start++]);
            }
        }

        return max;
    }

}
