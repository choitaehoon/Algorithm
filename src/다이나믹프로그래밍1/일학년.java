package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일학년 {

    public static int endNumber;
    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine())-1;
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        array = new int[number];
        long[][] d = new long[number][21];

        for (int i=0; i<number; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        endNumber = Integer.parseInt(token.nextToken());


        d[0][array[0]] = 1;

        for (int i=1; i<number; ++i)
            for (int j=0; j<=20; ++j) {
                if (0 <= j - array[i])
                    d[i][j] += d[i-1][j-array[i]];
                if (j + array[i] <= 20)
                    d[i][j] += d[i-1][j+array[i]];
            }

        System.out.println(d[number-1][endNumber]);
    }
}
