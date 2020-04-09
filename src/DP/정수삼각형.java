package DP;

import java.util.Arrays;

public class 정수삼각형 {

    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}
        ));
    }

    public static int solution(int[][] triangle) {
        int[][] sum = new int[triangle.length][triangle.length];

        sum[1][0] = triangle[0][0] + triangle[1][0];
        sum[1][1] = triangle[0][0] + triangle[1][1];

        for (int i=2; i<triangle.length; ++i) {
            for (int z=0; z<triangle[i].length; ++z) {
                if (z == 0) {
                    sum[i][z] = sum[i-1][z] + triangle[i][z];
                } else if (z == triangle[i].length - 1) {
                    sum[i][z] = sum[i-1][z-1] + triangle[i][z];
                } else {
                    int compareOne = sum[i-1][z - 1] + triangle[i][z];
                    int compareTwo = sum[i-1][z] + triangle[i][z];

                    sum[i][z] = Math.max(compareOne, compareTwo);
                }
            }
        }

        int max = 0;
        for (int i=0; i<triangle.length; ++i) {
            max = Math.max(max, sum[triangle.length-1][i]);
        }

        return max;
    }

}

