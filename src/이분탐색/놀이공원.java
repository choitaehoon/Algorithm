package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 놀이공원 {

    static int n;
    static int m;
    static int [] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        array = new int[m];

        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        for (int i=0; i<m; ++i)
            array[i] = Integer.parseInt(tokenizer.nextToken());

        long start = 0;
        long end = 2000000000L * 30;
        long b = 0;
        long num1 = 0;

        while (start <= end) {
            long middle = (start + end )/ 2 ;
            long res = calc(middle);

            if (res < n) {
                start = middle + 1;
                num1 = res;
            }
            else  {
                end = middle - 1;
                b = middle;
            }
        }

        long ans = num1;
        int idx  = 0;

        for (int i=0; i<m; ++i) {
            if (ans == n)
                break;
            if (b % array[i] == 0) {
                ans ++;
                idx = i + 1;
            }
        }

        System.out.println(idx);
    }

    static long calc(long mid) {
        long sum = m;

        for (int i=0; i<m; ++i)
            sum += mid / array[i];

        return sum;
    }

}
