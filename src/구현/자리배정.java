package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자리배정 {

    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int y = Integer.parseInt(token.nextToken());
        int x = Integer.parseInt(token.nextToken());
        int goal = Integer.parseInt(buffer.readLine());
        visit = new boolean[x][y];

        if (x * y < goal) {
            System.out.println(0);
            return;
        }

        solution(x, y, goal);
    }

    private static void solution(int x, int y, int goal) {
        int location = 1;
        int direction = 0;
        int xGo = x;
        int yGo = 0;

        while (location <= goal) {
            xGo = xGo + xMove[direction];
            yGo = yGo + yMove[direction];

            if (xGo < 0 || yGo < 0 || xGo >= x || yGo >= y || visit[xGo][yGo]) {
                xGo -= xMove[direction];
                yGo -= yMove[direction];
                direction = (direction + 1) % 4;
                continue;
            }

            visit[xGo][yGo] = true;
            ++location;
        }

        System.out.println((yGo + 1)+" "+(x - xGo));

    }

}
