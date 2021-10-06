package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴바이토닉부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int[] array = new int[n];
        int[] dpRight = new int[n];
        int[] dpLeft = new int[n];

        for (int i = 0; i < n; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        for (int i = 0; i < n; ++i) {
            dpRight[i] = 1;

            for (int k = 0; k < i; ++k) {
                if (array[k] < array[i]) {
                    dpRight[i] = Math.max(dpRight[i], dpRight[k] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; --i) {
            dpLeft[i] = 1;

            for (int k = n - 1; k > i; --k) {
                if (array[i] > array[k]) {
                    dpLeft[i] = Math.max(dpLeft[i], dpLeft[k] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; ++i) {
            max = Math.max(dpLeft[i] + dpRight[i], max);
        }

        System.out.println(max - 1);
    }

}
