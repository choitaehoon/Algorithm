package 구현;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {

    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{3,3,3,2,2,2}
        ));
    }

    public static int solution(int[] nums) {
        Set<Integer> kind = new HashSet<>();
        for (int value : nums)
            kind.add(value);

        return Math.min(kind.size(), nums.length / 2);
    }
}
