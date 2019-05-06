package 알고리즘중급.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 동전O {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        int[] array = new int[n];

        for (int i=0; i<n; ++i)
            array[i] = Integer.parseInt(buffer.readLine());

        int value = 0;
        int count = 0;
        for (int i=array.length-1; i>=0 ; --i) {
                while (value + array[i] <=  k) {
                    value += array[i];
                    count++;
                }
        }

        System.out.println(count);
    }
}
