package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 소수만들기 {

    static int sumStore;
    static Map<Integer,Integer> map = new HashMap<>();
    static int length;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,4}));
    }

    public static int solution(int[] nums) {

        length = nums.length;

        for (int i=2; i<1000000; ++i) {
            if (map.get(i) == null)
                for (int j= i+i; j<1000000; j+=i)
                    map.putIfAbsent(j, 1);
        }

        recursive(0,0, 0 ,nums);
        return sumStore;
    }

    private static void recursive(int index, int count, int sum ,int ... nums) {
        if (count == 3 ) {
            if (map.get(sum) == null) {
                ++sumStore;
            }
            return;
        }

        if (index >= length)
            return;

        recursive(index+1, count+1, sum+nums[index], nums);
        recursive(index+1, count, sum, nums );
    }

}
