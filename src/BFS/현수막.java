package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 현수막 {

    static int[] xMove = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] yMove = {0, 0, 1, -1, -1, 1, -1, 1};
    static boolean[][] visit;
    static int row;
    static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        row = Integer.parseInt(token.nextToken());
        col = Integer.parseInt(token.nextToken());

        int[][] array = new int[row][col];
        visit = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            StringTokenizer token1 = new StringTokenizer(buffer.readLine());
            for (int k = 0; k < col; ++k) {
                array[i][k] = Integer.parseInt(token1.nextToken());
            }
        }

        int sum = 0;
        for (int i = 0; i < row; ++i)
            for (int k = 0; k < col; ++k)
                if (!visit[i][k] && array[i][k] == 1) {
                    ++sum;
                    solution(i, k, array);
                }

        System.out.println(sum);
    }

    private static void solution(int x, int y, int[][] array) {
        visit[x][y] = true;

        for (int i = 0; i < 8; ++i) {
            int xGo = x + xMove[i];
            int yGo = y + yMove[i];

            if (xGo < 0 || xGo >= array.length || yGo < 0 || yGo >= array[0].length
                    || visit[xGo][yGo] || array[xGo][yGo] == 0)
                continue;

            solution(xGo, yGo, array);
        }
    }

}
