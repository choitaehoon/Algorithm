package study.프로그래머스;

import java.util.Arrays;

public class 숫자게임 {
    public static void main(String[] args) {

    }

    public int solution(int[] A, int[] B) {
        Arrays.parallelSort(A);
        Arrays.parallelSort(B);

        int sum = 0;
        for (int i=0; i<A.length; ++i)
            if (A[i] < B[i])
                ++sum;

            return sum;
    }

}
