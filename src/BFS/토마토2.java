package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 토마토2 {

    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0 ,0, 1, -1};
    static boolean[][] visit;
    static int days;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int y = Integer.parseInt(token.nextToken());
        int x = Integer.parseInt(token.nextToken());

        int[][] array = new int[x][y];
        visit = new boolean[x][y];
        for (int i = 0; i < x; ++i) {
            StringTokenizer token1 = new StringTokenizer(buffer.readLine());
            for (int k = 0; k < y; ++k)
                array[i][k] = Integer.parseInt(token1.nextToken());
        }

        solution(x, y, array);

        for (int i = 0; i < x; ++i) {
            for (int k = 0; k < y; ++k) {
                if (!visit[i][k] &&  array[i][k] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days);
    }

    private static void solution(int x, int y, int[][] array) {
        Queue<Pointer4> queue = new LinkedList<>();
        oneSearch(x, y, array, queue);

        while(!queue.isEmpty()) {
            Pointer4 pointer = queue.poll();
            int nowX = pointer.x;
            int nowY = pointer.y;
            int nowCount = pointer.count;

            for (int i = 0; i < 4; ++i) {
                int xGo = nowX + xMove[i];
                int yGo = nowY + yMove[i];

                if (xGo < 0 || xGo >= x || yGo < 0 || yGo >= y
                        || visit[xGo][yGo] || array[xGo][yGo] == -1)
                    continue;

                visit[xGo][yGo] = true;
                queue.offer(new Pointer4(xGo, yGo, pointer.count + 1));
                days = Math.max(nowCount + 1, days);
                solution(xGo, yGo, array);
            }
        }

    }

    private static void oneSearch(int x, int y, int[][] array, Queue<Pointer4> queue) {

        for (int i = 0; i < x; ++i) {
            for (int k = 0; k < y; ++k)
                if (array[i][k] == 1) {
                    queue.offer(new Pointer4(i, k, 0));
                    visit[i][k] = true;
                }
        }

    }
}

@SuppressWarnings("all")
class Pointer4 {
    int x;
    int y;
    int count;

    public Pointer4(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

}
