package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이0인네정수 {

    static int n;
    static int[][] array;
    static int[] arrayOne;
    static int[] arrayTwo;
    static long count;

    public static void main(String[] args) throws IOException {
        inputArray();
        binarySearchArray();
        System.out.println(count);
    }

    private static void inputArray() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
        array = new int[n][4];
        arrayOne = new int[n * n];
        arrayTwo = new int[n * n];

        for (int i=0; i<n; ++i) {
            StringTokenizer tokenizer =
                    new StringTokenizer(buffer.readLine());
            for (int j=0; j<4; ++j)
                array[i][j] = Integer.parseInt(tokenizer.nextToken());
        }

        int index = 0;
        for (int i=0; i<n; ++i) {
            for (int j=0; j<n; ++j) {
                arrayOne[index] = array[i][0] + array[j][1];
                arrayTwo[index++] = array[i][2] + array[j][3];
            }
        }

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
    }

    private static void binarySearchArray() {
        int left = 0;
        int right = n * n - 1;

        while (left < n*n && 0 <= right) {
            long leftValue = arrayOne[left];
            long rightValue = arrayTwo[right];
            long leftCount = 0;
            long rightCount = 0;

            if (leftValue + rightValue == 0) {
                while (left < arrayOne.length && arrayOne[left] == leftValue) {
                    leftCount++;
                    left++;
                }

                while (0 <= right && arrayTwo[right] == rightValue) {
                    rightCount++;
                    right--;
                }

                count += leftCount * rightCount;
            }

            if (leftValue + rightValue < 0) {
                left++;
            }

            if (leftValue + rightValue > 0) {
                right--;
            }
        }

    }

}
