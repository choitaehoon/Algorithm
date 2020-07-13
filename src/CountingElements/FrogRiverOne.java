package CountingElements;

public class FrogRiverOne {

    public static void main(String[] args) {
        System.out.println(solution(2, new int[]{2, 2, 2, 2, 2}));
    }

    public static int solution(int X, int[] A) {
        boolean[] isPossibleBridge = new boolean[X + 1];
        int minusX = X;

        for (int i = 0; i < A.length; ++i) {
            if (!isPossibleBridge[A[i]]) {
                isPossibleBridge[A[i]] = true;
                --minusX;
            }

            if (minusX == 0)
                return i;
        }

        return -1;
    }

}

