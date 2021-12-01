package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 통나무건너뛰기1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < n; ++i) {
            int circle = Integer.parseInt(buffer.readLine());
            int[] array = new int[circle];
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            storeArray(array, token, circle);

            printResult(array, circle);
        }
    }

    private static void storeArray(int[] array, StringTokenizer token, int circle) {
        for (int i = 0; i < circle; ++i) {
            array[i] = Integer.parseInt(token.nextToken());
        }
    }

    private static void printResult(int[] array, int circle) {
        Arrays.sort(array);
        int[] result = new int[circle];

        for (int i = 0, left = 0, right = circle - 1; i < circle; ++i) {
            if (i % 2 == 0) {
                result[left++] = array[i];
            } else {
                result[right--] = array[i];
            }
        }

        int max = 0;
        for (int i = 0; i < circle - 1; ++i) {
           max = Math.max(max, Math.abs(result[i] - result[i + 1]));
        }

        System.out.println(max);
    }

}
