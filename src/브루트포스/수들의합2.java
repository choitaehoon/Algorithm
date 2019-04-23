package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[] array = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        for (int i=0; i<n; ++i)
            array[i] = Integer.parseInt(tokenizer.nextToken());

        int s = 0;
        int e = 0;
        int sum = 0;
        int count = 0;

        while (s != n) {

            if (sum >= m || e == n)
                sum -= array[s++];

            else if (sum < m && e != n)
                sum += array[e++];

            if (sum == m)
                count++;
        }

        System.out.println(count);
    }
}
