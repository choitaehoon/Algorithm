package kakao;

import java.util.Arrays;
import java.util.Map;

public class 징검다리건너기 {

    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1},
                3
        ));
    }

    public static int solution(int[] stones, int k) {
        //기준값 조심
        int left = 0;
        int right = Integer.MAX_VALUE;
        int result = 0;

        while (left <= right) {
            int middle = (left + right) / 2;
            boolean isCheck = false;
            int[] newStones = createStones(stones);

            for (int i=0; i<newStones.length; ++i) {
                newStones[i] = newStones[i] - middle + 1;
            }

            int crossNum = 0;
            for (int i=0; i<newStones.length; ++i) {
                if (newStones[i] <= 0) {
                    ++crossNum;
                } else if (newStones[i] > 0)
                    crossNum = 0;

                if (crossNum < k) {
                    continue;
                } else if (crossNum == k) {
                    isCheck = true;
                    break;
                }

            }

            if (isCheck) {
                right = middle - 1;
            } else {
                left = middle + 1;
                result = middle;
            }

        }

        return result;
    }

    private static int[] createStones(int[] stones) {
        int[] newStone = new int[stones.length];

        for (int i=0; i<stones.length; ++i)
            newStone[i] = stones[i];

        return newStone;
    }

}
