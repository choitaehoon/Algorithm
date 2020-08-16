package medium;

public class Main718 {

    public static void main(String[] args) {
        System.out.println(findLength(
                new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}
        ));
    }

    public static int findLength(int[] A, int[] B) {
        int result = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = A.length - 1; i >= 0; --i) {
            for (int k = B.length - 1; k >= 0; --k) {
                if (A[i] == B[k])
                    dp[i][k] = dp[i + 1][k + 1] + 1;
                result = Math.max(result, dp[i][k]);
            }
        }

        return result;
    }

}
