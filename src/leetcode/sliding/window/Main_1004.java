package leetcode.sliding.window;

public class Main_1004 {

    public static void main(String[] args) {
        System.out.println(longestOnes(
                new int[]{1,1,1,0,0,0,1,1,1,1,0},
                2
        ));
    }

    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int s = 0, zeros = 0, ans = 0;

        for(int e=0;e<n;e++){

            if(nums[e]==0) zeros++;

            while(zeros>k){

                if(nums[s]==0) zeros--;

                s++;
            }

            ans = Math.max(ans, e-s+1);
        }

        return ans;
    }
}
