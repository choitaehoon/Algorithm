package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 데스나이트 {

    static int n;
    static int[] xMove = {-2, -2, 0, 0, 2, 2};
    static int[] yMove = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int r1 = Integer.parseInt(token.nextToken());
        int c1 = Integer.parseInt(token.nextToken());
        int r2 = Integer.parseInt(token.nextToken());
        int c2 = Integer.parseInt(token.nextToken());

        System.out.println(bfs(r1, c1, r2, c2));
    }

    private static int bfs(int r1, int c1, int r2, int c2) {
        Queue<Pointer1> queue = new LinkedList<>();
        boolean[][] check = new boolean[n + 1][n + 1];
        queue.add(new Pointer1(r1, c1, 0));
        check[r1][c1] = true;


        while (!queue.isEmpty()) {
            Pointer1 pointer1 = queue.poll();
            int x = pointer1.x;
            int y = pointer1.y;
            int count = pointer1.count;

            for (int i = 0; i < 6; ++i) {
                int xGo = x + xMove[i];
                int yGo = y + yMove[i];

                if (xGo < 0 || xGo > n || yGo < 0 || yGo > n || check[xGo][yGo])
                    continue;

                if (xGo == r2 && yGo == c2) {
                    return count + 1;
                }

                check[xGo][yGo] = true;
                queue.add(new Pointer1(xGo, yGo, count + 1));
            }
        }

        return  - 1;
    }


}

class Pointer1 {
    int x;
    int y;
    int count;

    public Pointer1(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

}
