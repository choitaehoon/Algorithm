package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 통나무건너뛰기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        for (int i = 0; i <n; ++i) {
            int len = Integer.parseInt(buffer.readLine());
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int[] array = new int[len];

            for (int k = 0; k < len; ++k)
                array[k] = Integer.parseInt(token.nextToken());

            solutionGo(array, len);
        }

    }

    private static void solutionGo(int[] array, int len) {
        Arrays.sort(array);

            int[] result = new int[len];
            for (int start = 0, end = len - 1, index = 0; index < len; ++index) {
                if (index % 2 == 0) {
                    result[start++] = array[index];
                } else {
                    result[end--] = array[index];
                }
            }

            int max = 0;
            for (int i = 0; i < len - 1; ++i) {
                max = Math.max(max, abs(result[i], result[i + 1]));
            }

            System.out.println(max);
    }

    private static int abs(int num1, int num2) {
        return Math.abs(num1 - num2);
    }
}
