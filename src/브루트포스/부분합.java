package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 부분합 {

    static int min = Integer.MAX_VALUE;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        array = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        for (int i=0; i<n; ++i)
            array[i] = Integer.parseInt(tokenizer.nextToken());

        int s = 0;
        int e = 0;
        int length = 0;
        int sum = 0;
        boolean check = false;

        while (s < n) {
            if (m <= sum || e == n) {
                sum -= array[s++];
                length--;
            }

            else if (sum < m && e != n) {
                sum += array[e++];
                length++;
            }

            if (m <= sum) {
                check = true;
                min = Math.min(min,length);
            }
        }

        System.out.println(check ? min : 0);
    }
}
