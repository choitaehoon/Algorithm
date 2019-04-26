package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 이동하기반복문 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[][] array = new int[n + 1][m + 1];
        int[][] sumArray = new int[n + 1][m + 1];

        for (int i = 1; i <= n; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
            for (int j = 1; j <= m; ++j)
                array[i][j] = Integer.parseInt(tokenizer.nextToken());
        }


        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= m; ++j)
                sumArray[i][j] = Math.max(sumArray[i - 1][j - 1], Math.max(sumArray[i - 1][j], sumArray[i][j - 1])) + array[i][j];

        System.out.println(sumArray[n][m]);
    }
}
