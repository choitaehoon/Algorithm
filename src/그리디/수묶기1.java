package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수묶기1 {

    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(buffer.readLine());
        }

        Arrays.sort(array);
        solution(array, n);
    }

    private static void solution(int[] array, int n) {
        int start = 0;
        int end = n - 1;
        int value = 0;

        for (; start < end; start += 2) {
            if (array[start] < 1 && array[start + 1] < 1) {
                value += array[start] * array[start + 1];
            }
            else
                break;
        }

        for (; end > start; end -= 2) {
            if (array[end] > 1 && array[end - 1] > 1) {
                value += array[end] * array[end - 1];
            } else
                break;
        }

        for (int i = start; i <= end; ++i) {
            value += array[i];
        }

        System.out.println(value);
    }

}
