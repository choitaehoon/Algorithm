package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로 {

    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        permutation(array, 0, n, n);
        System.out.println(max);
    }

    private static void permutation(int[] array, int depth, int n, int r) {
        if (depth == r) {
            int len = array.length;
            int nowMax = 0;
            for (int i = 1; i < len; ++i)
                nowMax += Math.abs(array[i] - array[i - 1]);
            max = Math.max(max, nowMax);
            return;
        }

        for (int i = depth; i < n; ++i) {
            swap(array, depth, i);
            permutation(array, depth + 1, n, r);
            swap(array, depth, i);
        }
    }

    private static void swap(int[] array, int depth, int i) {
        int temp = array[depth];
        array[depth] = array[i];
        array[i] = temp;
    }

}
