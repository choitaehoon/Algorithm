package easy;

import java.util.Arrays;

public class Main189 {

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }

    private static void rotate(int[] nums, int k) {

        int pre;
        for (int i = 0; i < k; ++i) {
            pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; ++j) {
                int temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

}
