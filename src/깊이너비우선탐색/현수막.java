package 깊이너비우선탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 현수막 {

    static int[] xMove = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] yMove = {1, -1, 0, 0, -1, 1, 1, -1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int x = Integer.parseInt(token.nextToken());
        int y = Integer.parseInt(token.nextToken());

        int[][] array = new int[x][y];
        visit = new boolean[x][y];
        for (int i = 0; i < x; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
            for (int k =0; k < y; ++k)
                array[i][k] = Integer.parseInt(tokenizer.nextToken());
        }

        int count = 0;
        for (int i = 0; i < x; ++i)
            for (int k = 0; k < y; ++k)
                if (!visit[i][k] && array[i][k] == 1) {
                    ++count;
                    dfs(i, k, x, y, array);
                }

        System.out.println(count);
    }

    private static void dfs(int x, int y, int xEnd, int yEnd, int[][] array) {
        visit[x][y] = true;

        for (int i = 0; i < 8; ++i) {
            int xGo = x + xMove[i];
            int yGo = y + yMove[i];

            if (xGo < 0 || xGo >= xEnd || yGo < 0 || yGo >= yEnd
                    || visit[xGo][yGo] || array[xGo][yGo] == 0)
                continue;

            dfs(xGo, yGo, xEnd, yEnd, array);
        }
    }

}
