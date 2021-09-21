package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬 {

    static int max;
    static int[][] cache;
    static char[][] array;
    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int row = Integer.parseInt(token.nextToken());
        int col = Integer.parseInt(token.nextToken());

        array = new char[row][col];
        cache = new int[row][col];

        for (int i = 0; i < row; ++i) {
            String word = buffer.readLine();
            for (int k = 0; k < col; ++k)
                array[i][k] = word.charAt(k);
        }

        for (int i = 0; i < row; ++i) {
            for (int k = 0; k < col; ++k) {
                if (array[i][k] == 'L') {
                    solution(i, k, row, col);
                    cacheClean(row, col);
                }
            }
        }

        System.out.println(max - 1);
    }

    private static void solution(int x, int y, int row, int col) {
        Queue<Move> queue = new LinkedList<>();
        queue.offer(new Move(x, y));
        cache[x][y] = 1;

        while (!queue.isEmpty()) {
            Move move = queue.poll();

            int moveX = move.x;
            int moveY = move.y;

            max = Math.max(max, cache[moveX][moveY]);

            for (int i = 0; i < 4; ++i) {
                int xGo = moveX + xMove[i];
                int yGo = moveY + yMove[i];

                if (xGo < 0 || xGo >= row || yGo < 0 || yGo >= col
                        || cache[xGo][yGo] != 0 || array[xGo][yGo] == 'W')
                    continue;

                cache[xGo][yGo] = cache[moveX][moveY] + 1;
                queue.offer(new Move(xGo, yGo));
            }
        }
    }

    private static void cacheClean(int row, int col) {
        for (int i = 0; i < row; ++i)
            for (int k = 0; k < col; ++k)
                cache[i][k] = 0;
    }

}

class Move {

    int x;
    int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

}