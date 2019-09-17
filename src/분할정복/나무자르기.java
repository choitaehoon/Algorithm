package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 나무자르기 {

    static int n;
    static int m;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        array = new int[n];

        StringTokenizer tree = new StringTokenizer(buffer.readLine());
        for (int i=0; i<n; ++i)
            array[i] = Integer.parseInt(tree.nextToken());

        Arrays.sort(array);
        System.out.println(calculate());
    }

    private static long calculate() {
        long start = 0;
        long end = array[n-1];
        long max = 0;

        while (start <= end){
            long middle = (start+end)/2;
            long height = 0;

            for (int i=0; i<n; ++i) {
                if (array[i] - middle > 0)
                    height += array[i] - middle;
            }

            if (height < m)
                end = middle - 1;
            else {
                start = middle +1;
                max = Math.max(max,middle);
            }

        }

        return max;
    }

}
