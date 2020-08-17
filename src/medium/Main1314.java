package medium;

import java.util.Arrays;

public class Main1314 {

    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(matrixBlockSum(
//                new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}, 1
//        )));
        System.out.println(Arrays.deepToString(matrixBlockSum(
                new int[][]{{1,2,3}}, 5
        )));
    }

    public static int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] resultMatrix = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int k = 0; k < n; ++k) {
                resultMatrix[i][k] = resultMatrixInsert(i, k, K, mat);
            }
        }

        return resultMatrix;
    }

    private static int  resultMatrixInsert(int row, int column, int K, int[][] mat) {
        int sumMat = 0;

        for (int i = row - K; i <= row + K; ++i) {
            for (int k = column - K; k <= column + K; ++k) {
                if (i < 0 || i >= mat.length || k < 0 || k >= mat[0].length)
                    continue;

                sumMat += mat[i][k];
            }
        }

        return sumMat;
    }

}
