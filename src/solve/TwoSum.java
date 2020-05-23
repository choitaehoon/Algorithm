package solve;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(
                new int[]{2, 7, 11, 15}, 9))
        );
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] resultTwoSum = new int[2];
        loop : for (int i=0; i<nums.length; ++i) {
            for (int j=i+1; j<nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    resultTwoSum[0] = i;
                    resultTwoSum[1] = j;
                    break loop;
                }
            }
        }

        return resultTwoSum;
    }

    public static int[] twoSumSolveTwo(int[] nums, int target) {

        Map<Integer, Integer> valueAndPosition = new HashMap<>();
        for (int i=0; i<nums.length; ++i) {
            valueAndPosition.put(nums[i], i);
        }

        for (int i=0; i<nums.length; ++i) {
            int minusTargetAndNums = target - nums[i];
            if (valueAndPosition.containsKey(minusTargetAndNums) && valueAndPosition.get(minusTargetAndNums) != i) {
                return new int[]{i, valueAndPosition.get(minusTargetAndNums)};
            }
        }

        throw new IllegalArgumentException("no two sum!");
    }
}
