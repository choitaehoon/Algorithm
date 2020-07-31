package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static Queue<Point> queue = new LinkedList<>();
    static int xLimit;
    static int yLimit;
    static int min = Integer.MAX_VALUE;
    static int[][] dp;

    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}
        ));
    }

    public static int solution(int[][] maps) {
        xLimit = maps.length - 1;
        yLimit = maps[0].length - 1;
        queue.offer(new Point(0,0, 1));
        dp = new int[xLimit + 1][yLimit + 1];

        for (int[] value : dp)
            Arrays.fill(value, Integer.MAX_VALUE);
        dp[0][0] = 1;

        searchGo(maps);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static void searchGo(int[][] maps) {

        while (!queue.isEmpty()) {
            Point nowPoint = queue.poll();
            int nowX = nowPoint.x;
            int nowY = nowPoint.y;
            int nowCost = nowPoint.cost;

            if (nowX == xLimit && nowY == yLimit) {
                min = Math.min(min, nowCost);
                continue;
            }

            for (int i = 0; i < 4; ++i) {
                int nextX = nowX + xMove[i];
                int nextY = nowY + yMove[i];

                if (nextX < 0 || nextX > xLimit || nextY < 0 || nextY > yLimit || maps[nextX][nextY] == 0 || dp[nextX][nextY] != Integer.MAX_VALUE)
                    continue;

                dp[nextX][nextY] = nowCost + 1;
                queue.offer(new Point(nextX, nextY, nowCost + 1));
            }

        }
    }

}

class Point {

    int x;
    int y;
    int cost;

    public Point(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

}
