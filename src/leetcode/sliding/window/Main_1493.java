package leetcode.sliding.window;

public class Main_1493 {

    public static void main(String[] args) {
        System.out.println(
                longestSubarray(
                        new int[]{0,1,1,1,0,1,1,0,1}
                )
        );
    }

    public static int longestSubarray(int[] nums) {

        int longest = Integer.MIN_VALUE;

        for (int right = 0, left = 0, zeroes = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                zeroes++;
            if (zeroes <= 1)
                longest = Math.max(longest, right - left + 1);
            while (zeroes > 1)
                if (nums[left++] == 0)
                    zeroes--;
        }

        return longest == Integer.MIN_VALUE ? 0 : longest - 1;

    }
}
