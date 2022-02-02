package leetcode;

public class Main_35 {

    public int searchInsert(int[] nums, int target) {
        for(int i = 0, len = nums.length; i < len; i++){
            if(nums[i] == target){
                return i;
            } else{
                if(nums[i] > target)
                    return i;
                else
                    continue;
            }
        }

        return nums.length;
    }

}
