package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 랜선자르기 {

    static int[] array;
    static int k;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        k = Integer.parseInt(token.nextToken());
        n = Integer.parseInt(token.nextToken());
        array = new int[k];

        for (int i=0; i<k; ++i)
            array[i] = Integer.parseInt(buffer.readLine());

        Arrays.sort(array);

        System.out.println(trimMax());
    }

    private static int trimMax() {
        int max = 0;
        int start = 1;
        int end = array[array.length-1];
        int length = array.length;

        while (start <= end){
            int middle = (start+end)/2;
            int value = 0;

            for (int i=0; i<length; ++i)
                value += (array[i] / middle);

            if (value < k) {
                end = middle - 1;
            }

            else if (value >= k){
                max = middle;
                start = middle + 1;
            }
        }

        return max;
    }

}
