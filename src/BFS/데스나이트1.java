package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 데스나이트1 {

    static int[] xMove = {-2, -2, 0, 0, 2, 2};
    static int[] yMove = {-1, 1, -2, 2, -1, 1};
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int r1 = Integer.parseInt(token.nextToken());
        int c1 = Integer.parseInt(token.nextToken());
        int r2 = Integer.parseInt(token.nextToken());
        int c2 = Integer.parseInt(token.nextToken());
        check = new boolean[n + 1][n + 1];

        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(r1, c1, 0));
        check[r1][c1] = true;
        solution(queue, r2, c2, n);
    }

    private static void solution(Queue<Location> queue, int r2, int c2, int n) {
        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int x = location.x;
            int y = location.y;

            for (int i = 0; i < 6; ++i) {
                int xGo = x + xMove[i];
                int yGo = y + yMove[i];

                if (xGo < 0 || xGo > n || yGo < 0 || yGo > n || check[xGo][yGo])
                    continue;

                if (xGo == r2 && yGo == c2) {
                    System.out.println(location.count + 1);
                    return;
                }

                check[xGo][yGo] = true;
                queue.offer(new Location(xGo, yGo, location.count + 1));
            }
        }

        System.out.println(-1);
    }

}

class Location {
    int x;
    int y;
    int count;

    public Location(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

}
