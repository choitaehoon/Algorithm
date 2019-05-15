package study.중급;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {

    static int[][] connection;
    static int sum;
    static int computerTotal;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        computerTotal = Integer.parseInt(buffer.readLine());
        int repeat = Integer.parseInt(buffer.readLine());
        connection = new int[computerTotal+1][computerTotal+1];
        check = new boolean[computerTotal+1];

        for (int i=0; i<repeat; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());

            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            connection[x][y] = 1;
            connection[y][x] = 1;
        }

        check[1] = true;
        dfs(1);

        System.out.println(sum);
    }

    static void dfs(int start) {
        check[start] = true;

        for (int i=1; i<=computerTotal; ++i)
            if (connection[start][i] == 1 && !check[i]) {
                ++sum;
                dfs(i);
            }
    }
}
