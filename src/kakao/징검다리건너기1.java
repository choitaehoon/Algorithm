package kakao;

public class 징검다리건너기1 {

    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1},
                3
        ));
    }

    public static int solution(int[] stones, int k) {

        int left = 0;
        int right = Integer.MAX_VALUE;
        int result = 0;

        while (left <= right) {
            int middle = (left + right) / 2;
            int[] newStone = createNewStone(stones);

            for (int i=0; i<stones.length; ++i) {
                newStone[i] = newStone[i] - middle + 1;
            }

            int zeroDown = 0;
            boolean isCheck = false;
            for (int i=0; i<stones.length; ++i) {
                if (newStone[i] <= 0) {
                    ++zeroDown;
                } else if (newStone[i] > 0)
                    zeroDown = 0;

                if (zeroDown == k){
                    isCheck = true;
                    break;
                }
            }
ㅈ
            if (isCheck) {
                right = middle - 1;
            } else {
                left = middle + 1;
                result = middle;
            }

        }

        return result;
    }

    private static int[] createNewStone(int[] stones) {
        int[] newStone = new int[stones.length];

        for (int i=0; i<stones.length; ++i)
            newStone[i] = stones[i];

        return newStone;
    }

}
