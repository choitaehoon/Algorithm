package easy;

import java.util.Arrays;

public class Main581 {

    public static void main(String[] args) {

    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] numsStore = nums.clone();
        Arrays.sort(numsStore);
        int numsLen = nums.length;
        int start = nums.length;
        int end = 0;

        for (int i = 0; i < numsLen; ++i) {
            if (numsStore[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        return end - start >= 0 ? end - start + 1 : 0;
    }

}
