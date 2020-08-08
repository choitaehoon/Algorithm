package medium;

public class Main1035 {

    public static void main(String[] args) {

    }

    public int maxUncrossedLines(int[] A, int[] B) {

        int[][] lcs = new int[A.length + 1][B.length + 1];

        for (int i = 1; i <= A.length; ++i) {
            for (int k = 1; k <= B.length; ++k) {
                if (A[i - 1] == B[k - 1])
                    lcs[i][k] = lcs[i - 1][k - 1] + 1;
                else
                    lcs[i][k] = Math.max(lcs[i - 1][k], lcs[i][k - 1]);
            }
        }

        return lcs[A.length][B.length];
    }

}
