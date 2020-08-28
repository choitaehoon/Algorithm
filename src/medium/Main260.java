package medium;

import java.util.Arrays;

public class Main260 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(
                new int[]{1,2,1,3,2,5}
        )));
    }

    public static int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int numsLen = nums.length;
        int[] result = new int[2];

        for (int i = 0; i < numsLen - 1; ) {
            if (nums[i] != nums[i + 1]) {
                result[count++] = nums[i];
                ++i;
            } else {
                i += 2;
            }
        }

        if (count == 1) {
            result[count] = nums[numsLen - 1];
        }

        return result;
    }

}
