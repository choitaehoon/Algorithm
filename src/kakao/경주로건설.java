package kakao;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {

    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static Queue<PointerLocation> queue = new LinkedList<>();
    static int[][] isGoCheck;
    static int result = 100_000_000;
    static int len;

    public static void main(String[] args) {

    }

    public static int solution(int[][] board) {
        len = board.length;
        isGoCheck = new int[len][len];

        queue.offer(new PointerLocation(0, 0, 0, -1));
        bfs(board);

        return result;
    }

    private static void bfs(int[][] board) {

        while (!queue.isEmpty()) {
            PointerLocation pointer = queue.poll();
            int nowX = pointer.x;
            int nowY = pointer.y;
            int nowCost = pointer.cost;
            int nowDirection = pointer.direction;

            if (nowX == len - 1 && nowY == len - 1) {
                result = Math.min(result, nowCost);
                continue;
            }

            for (int i = 0; i < 4; ++i) {
                int nextX = nowX + xMove[i];
                int nextY = nowY + yMove[i];
                int newCost;

                if (nextX < 0 || nextX >= len || nextY < 0 || nextY >= len  || board[nextX][nextY] == 1)
                    continue;

                if (nowDirection == -1 || nowDirection == i)
                    newCost = nowCost + 100;
                else {
                    newCost = nowCost + 600;
                }

                if (isGoCheck[nextX][nextY] == 0 || isGoCheck[nextX][nextY] >= newCost) {
                    isGoCheck[nextX][nextY] = newCost;
                    queue.offer(new PointerLocation(nextX, nextY, newCost, i));
                }
            }

        }

    }

}

class PointerLocation {

    int x;
    int y;
    int cost;
    int direction;

    public PointerLocation(int x, int y, int cost, int direction) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.direction = direction;
    }

}