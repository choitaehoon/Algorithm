package 정렬;

import java.util.Arrays;

public class MaxProductOfThree {

    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int endLengthA = A.length - 1;

        return Math.max(A[endLengthA] * A[endLengthA - 1] * A[endLengthA - 2], A[0] * A[1] * A[endLengthA]);
    }
}
