package 알고리즘중급.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int k = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());
        int[] array = new int[k];

        for (int i=0; i<k; ++i) {
            int number = Integer.parseInt(buffer.readLine());
            array[i] = number;
        }

        Arrays.sort(array);

        long s = 1;
        long e = array[k-1];
        long sum = 0;

        while (s <= e) {
            long middle = (s + e) /2;
            long count = 0;

            for (int i=0; i<k; ++i)
                count += array[i] / middle;

            if (count < n)
                e = middle - 1;
            else if (count >= n) {
                s = middle + 1;
                sum = Math.max(sum,middle);
            }
        }

        System.out.println(sum);
    }
}
