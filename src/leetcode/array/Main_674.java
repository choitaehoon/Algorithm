package leetcode.array;

public class Main_674 {

    public int findLengthOfLCIS(int[] nums) {
        int numsLen = nums.length;
        int count = 1;
        int max = 1;

        for (int i = 1; i < numsLen; ++i) {
            if (nums[i - 1] < nums[i]) {
                ++count;
            } else {
                count = 1;
            }

            max = Math.max(max, count);
        }

        return max;
    }

}
