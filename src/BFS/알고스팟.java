package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알고스팟 {

    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, 1, -1};
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int y = Integer.parseInt(token.nextToken());
        int x = Integer.parseInt(token.nextToken());

        int[][] array = new int[x][y];
        int[][] dist = new int[x][y];

        for (int i = 0; i < x; ++i) {
            String word = buffer.readLine();
            for (int k = 0; k < y; ++k) {
                array[i][k] = Integer.parseInt(String.valueOf(word.charAt(k)));
            }
        }

        for (int i = 0; i < x; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<Pointer2> queue = new LinkedList<>();
        dist[0][0] = 0;
        queue.offer(new Pointer2(0, 0));
        solution(queue, array, dist, x, y);
    }

    private static void solution(Queue<Pointer2> queue, int[][] array, int[][] dist, int x, int y) {
        while (!queue.isEmpty()) {
            Pointer2 pointer = queue.poll();
            int x1 = pointer.x;
            int y1 = pointer.y;

            for (int i = 0; i < 4; ++i) {
                int xGo1 = x1 + yMove[i];
                int yGo1 = y1 + xMove[i];

                if (yGo1 < 0 || yGo1 >= y || xGo1 < 0 || xGo1 >= x)
                    continue;

                if (array[xGo1][yGo1] == 1) {
                    if (dist[xGo1][yGo1] > dist[x1][y1] + 1) {
                        dist[xGo1][yGo1] = dist[x1][y1] + 1;
                        queue.offer(new Pointer2(xGo1, yGo1));
                    }
                }

                if (array[xGo1][yGo1] == 0) {
                    if (dist[xGo1][yGo1] > dist[x1][y1]) {
                        dist[xGo1][yGo1] = dist[x1][y1];
                        queue.offer(new Pointer2(xGo1, yGo1));
                    }
                }
            }
        }

        System.out.println(dist[x - 1][y - 1]);
    }

}

class Pointer2 {
    int x;
    int y;

    public Pointer2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}