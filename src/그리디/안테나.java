package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 안테나 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int[] array = new int[n];

        StringTokenizer token = new StringTokenizer(buffer.readLine());
        for (int i = 0; i < n; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        Arrays.sort(array);
        int len = array.length;

        int pivot = len % 2 == 0 ? (len / 2) - 1 : len / 2;
        System.out.println(array[pivot]);
    }

}
