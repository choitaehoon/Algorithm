package leetcode.greedy;

public class Main_1827 {

    public int minOperations(int[] nums) {
        int sum = 0;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] < nums[i])
                continue;

            int pre = nums[i - 1];
            int plus = pre - nums[i] + 1;
            sum += plus;
            nums[i] = pre + 1;
        }

        return sum;
    }

}
