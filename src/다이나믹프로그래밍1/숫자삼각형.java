package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        int[][] array = new int[number+1][number+1];
        int max = 0;

        for (int i=1; i<=number; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
            for (int j=1; j<=i; ++j) {
                array[i][j] = Integer.parseInt(tokenizer.nextToken());

                if (i == j)
                    array[i][j] = array[i-1][j-1] + array[i][j];
                else if (j == 1)
                    array[i][j] = array[i-1][j] + array[i][j];
                else
                    array[i][j] = Math.max(array[i-1][j-1],array[i-1][j]) + array[i][j];

                max = Math.max(max,array[i][j]);
            }
        }

        System.out.println(max);
    }
}
