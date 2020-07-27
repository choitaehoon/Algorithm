package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇청소기1 {

    static int count;
    static int[][] array;
    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static int N;
    static int M;
    static Queue<Pointer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        StringTokenizer robot = new StringTokenizer(buffer.readLine());
        int x = Integer.parseInt(robot.nextToken());
        int y = Integer.parseInt(robot.nextToken());
        int direction = Integer.parseInt(robot.nextToken());
        queue.offer(new Pointer(x, y, direction));

        array = new int[N][M];
        for (int i = 0; i < N; ++i) {
            StringTokenizer line = new StringTokenizer(buffer.readLine());
            for (int k = 0; k < M; ++k)
                array[i][k] = Integer.parseInt(line.nextToken());
        }

        cleanSearch();

        System.out.println(count);
    }

    private static void cleanSearch() {

        while (!queue.isEmpty()) {
            Pointer nowPointer = queue.poll();
            nowCleanGo(nowPointer);
            nowSearchGo(nowPointer);
            noCleanCheck(nowPointer);
        }

    }

    private static void nowCleanGo(Pointer nowPointer) {
        int nowX = nowPointer.x;
        int nowY = nowPointer.y;

        if (array[nowX][nowY] == 0) {
            array[nowX][nowY] = 2;
            ++count;
        }
    }

    private static void nowSearchGo(Pointer nowPointer) {
        int nowX = nowPointer.x;
        int nowY = nowPointer.y;
        int nowDirection = nowPointer.direction;

        for (int i = 0; i < 4; ++i) {
            int nextX = nowX + xMove[(nowDirection + 3 - i) % 4];
            int nextY = nowY + yMove[(nowDirection + 3 - i) % 4];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || array[nextX][nextY] != 0)
                continue;

            queue.offer(new Pointer(nextX, nextY, (nowDirection + 3 - i) % 4));
            break;
        }
    }

    private static void noCleanCheck(Pointer nowPointer) {
        if (queue.isEmpty()) {
            int nextX = nowPointer.x + xMove[(nowPointer.direction + 2) % 4];
            int nextY = nowPointer.y + yMove[(nowPointer.direction + 2) % 4];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || array[nextX][nextY] == 1)
                return;

            queue.offer(new Pointer(nextX, nextY, nowPointer.direction));
        }
    }

}

class Pointer {

    int x;
    int y;
    int direction;

    public Pointer(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

}