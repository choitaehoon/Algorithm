package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분수열의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int[] array = new int[n + 1];
        int[] sum = new int[n + 1];

        for (int i = 1; i <= n; ++i)
            array[i] = Integer.parseInt(token.nextToken());
        Arrays.sort(array);

        for (int i = 1; i <=n; ++i)
            sum[i] = array[i] + sum[i - 1];

        solution(array, sum, n);
    }

    private static void solution(int[] array, int[] sum, int n) {
        for (int i = 1; i <=n; ++i) {
            if (array[i] > sum[i - 1] + 1) {
                System.out.println(sum[i - 1] + 1);
                return;
            }
        }

        System.out.println(sum[n] + 1);
    }

}
