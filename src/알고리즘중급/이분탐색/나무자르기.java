package 알고리즘중급.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int[] array = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        for (int i=0; i<n; ++i)
            array[i] = Integer.parseInt(tokenizer.nextToken());

        Arrays.parallelSort(array);

        int s = 0;
        int e = array[n-1];

        while (s <= e) {
            int middle = (s + e) / 2;
            long sum = 0;

            for (int i=0; i<n; ++i)
                if (array[i] - middle > 0)
                    sum += array[i] - middle;

            if (sum >= m)
                s = middle +1;

            else e = middle -1;

        }

        System.out.println(e);

    }
}
