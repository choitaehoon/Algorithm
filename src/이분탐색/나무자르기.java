package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기 {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        StringTokenizer tree = new StringTokenizer(buffer.readLine());

        int[] array = new int[n];

        for (int i=0; i<n; ++i)
            array[i] = Integer.parseInt(tree.nextToken());

        Arrays.parallelSort(array);

        int start = 0;
        int end = array[n-1];

        while (start <= end) {
            int middle = (start+end)/2;
            long sum = 0;

            for (int i=0; i<n; ++i)
                if (array[i] - middle > 0)
                    sum += array[i] - middle;

            if (k <= sum)
                start = middle + 1;

            else
                end = middle - 1;
        }

        System.out.println(end);

    }
}
