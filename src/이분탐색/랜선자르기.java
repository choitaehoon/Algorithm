package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선자르기 {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int k = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());
        long max = 0;
        int [] array = new int[k];

        for (int i=0; i<k; ++i)
            array[i] = Integer.parseInt(buffer.readLine());

        Arrays.sort(array);

        long start = 1;
        long end = array[k-1];

        while ( start<=end ) {
            long middle = (start+end)/2;
            long sum = 0;

            for (int i=0; i<k; ++i)
                sum += (array[i] / middle);

            if (sum >= n) {
                start = middle+1;
                max = Math.max(max,middle);
            }

            else
                end = middle-1;
        }

        System.out.println(max);
    }


}
