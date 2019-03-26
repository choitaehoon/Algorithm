package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 조짜기 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        int[] array = new int[number+1];
        int[] d = new int[number+1];

        StringTokenizer token = new StringTokenizer(buffer.readLine());

        for (int i=1; i<=number; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        for (int i=1; i<=number; ++i) {
            d[i] = d[i-1];
            int max = array[i];
            int min = array[i];

            for (int j = i-1; j>=1; --j) {
                if (max < array[j])
                    max = array[j];
                if (array[j] < min)
                    min = array[j];
                if (d[i] < d[j-1] + (max - min))
                    d[i] = d[j-1] + (max - min);
            }
        }

        System.out.println(d[number]);
    }
}
