package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬의개수 {

    static int countLand;
    static boolean[][] isLand;
    static int[][] square;
    static int[] xMove = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] yMove = {0, 1, 0, -1, -1, 1, 1, -1};
    static int width;
    static int vertical;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        do {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            vertical = Integer.parseInt(token.nextToken());
            width = Integer.parseInt(token.nextToken());

            square = new int[width][vertical];
            isLand = new boolean[width][vertical];

            for (int i = 0; i < width; ++i) {
                StringTokenizer landAndSea = new StringTokenizer(buffer.readLine());
                for (int j = 0; j < vertical; ++j)
                    square[i][j] = Integer.parseInt(landAndSea.nextToken());
            }

            for (int i = 0; i < width; ++i) {
                for (int j = 0; j < vertical; ++j) {
                    if (!isLand[i][j] && square[i][j] == 1) {
                        ++countLand;
                        landSearch(i, j);
                    }
                }
            }

            if (!(width == 0 && vertical == 0))
                System.out.println(countLand);
            countLand = 0;
        } while (!(width == 0 && vertical == 0));

    }

    private static void landSearch(int x, int y) {
        isLand[x][y] = true;

        for (int i = 0; i < 8; ++i) {
            int xGo = x + xMove[i];
            int yGo = y + yMove[i];

            if (xGo < 0 || xGo >= width || yGo < 0 || yGo >= vertical || isLand[xGo][yGo] || square[xGo][yGo] == 0)
                continue;

            landSearch(xGo, yGo);
        }
    }

}
