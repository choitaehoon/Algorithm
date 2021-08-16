package leetcode.sliding.window;

public class Main_724 {

    public int pivotIndex(int[] nums) {
        int numsLen = nums.length;
        int[] sum = new int[numsLen];

        for (int i = 0; i < numsLen; ++i) {
            if(i == 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }

        for (int i = 0; i < numsLen; ++i) {
            if(i == 0) {
                if (sum[numsLen - 1] - nums[0] == 0)
                    return 0;
            } else if (i == numsLen - 1) {
                if (sum[numsLen - 1] - nums[i] == 0)
                    return i;
            } else {
                if (sum[i - 1] == sum[numsLen - 1] - sum[i])
                    return i;
            }
        }

        return -1;
    }

}
