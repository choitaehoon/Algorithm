package study.프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 입국심사 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int [] array = new int[n];
        for (int i=0; i<n; ++i)
            array[i] = Integer.parseInt(buffer.readLine());

        long low = 1;
        long high = 1000000000000000000L;
        long min = Long.MAX_VALUE;

        while (low <= high) {
            long middle = (low + high)/2;
            long result = 0;

            for (int i=0; i<n; ++i)
                result += middle / array[i];

            if (result >= m) {
                min = Math.min(min,middle);
                high = middle -1;
            }

            else
                low = middle +1;

        }

        System.out.println(min);
    }
}
