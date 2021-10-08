package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알바생강호 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; ++i)
            array[i] = Integer.parseInt(buffer.readLine());

        Arrays.sort(array);
        long sum = 0;
        for (int i = n - 1, rank = 1; i >= 0; --i, ++rank) {
            int tip = array[i] - (rank - 1);
            if (tip <= 0)
                continue;

            sum += tip;
        }

        System.out.println(sum);
    }

}
