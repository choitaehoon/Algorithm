package solve;

import java.util.Arrays;

public class 숫자게임 {

    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{5,1,3,7}, new int[]{2,2,6,8}
        ));
    }

    public static int solution(int[] A, int[] B) {
        int len = A.length;
        int left = 0;
        int right = len - 1;
        int sum = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i=len - 1; i >= 0; --i) {
            if (A[i] < B[right]) {
                sum++;
                right--;
            } else {
                left++;
            }
        }

        return sum;
    }

}