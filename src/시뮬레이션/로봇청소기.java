package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇청소기 {

    static int[][] map;
    static Queue<Coordinate> queue = new LinkedList<>();
    //북동남서
    static int[] xMove = {-1,0,1,0};
    static int[] yMove = {0,1,0,-1};
    static int sum;
    static int x, y;

    public static void main(String[] args) throws IOException {
        inputMapAndRobot();
        actionRobot();
        System.out.println(sum);
    }

    private static void inputMapAndRobot() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer mapSize =
                new StringTokenizer(buffer.readLine());
        StringTokenizer coordinate =
                new StringTokenizer(buffer.readLine());

        x = Integer.parseInt(mapSize.nextToken());
        y = Integer.parseInt(mapSize.nextToken());

        map = new int[x][y];

        int robotX = Integer.parseInt(coordinate.nextToken());
        int robotY = Integer.parseInt(coordinate.nextToken());
        int robotStart = Integer.parseInt(coordinate.nextToken());

        queue.offer(new Coordinate(robotX, robotY, robotStart));

        for (int i=0; i<x; ++i) {
            StringTokenizer token =
                    new StringTokenizer(buffer.readLine());
            for (int j=0; j<y; ++j) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
    }

    private static void actionRobot() {
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();

            checkNoCleanMap(coordinate);
            cleanGo(coordinate);
            cleanNo(coordinate);
        }
    }

    private static void checkNoCleanMap(Coordinate coordinate) {
        if (map[coordinate.x][coordinate.y] == 0) {
            map[coordinate.x][coordinate.y] = 2;
            sum++;
        }
    }

    private static void cleanGo(Coordinate coordinate) {

        for (int i=0; i<4; ++i) {
            int xGo = coordinate.x + xMove[(coordinate.direction + 3 - i) % 4];
            int yGo = coordinate.y + yMove[(coordinate.direction + 3 - i) % 4];

            if (xGo < 0 || xGo >= x || yGo < 0 || yGo >= y || map[xGo][yGo] != 0)
                continue;

            queue.offer(new Coordinate(xGo, yGo, (coordinate.direction + 3 - i) %4));
            break;
        }

    }

    private static void cleanNo(Coordinate coordinate) {
        while (queue.isEmpty()) {
            int xGo = coordinate.x + xMove[(coordinate.direction + 2) % 4];
            int yGo = coordinate.y + yMove[(coordinate.direction + 2) % 4];

            if (xGo < 0 || xGo >= x || yGo < 0 || yGo >= y || map[xGo][yGo] == 1)
                break;

            queue.offer(new Coordinate(xGo, yGo, coordinate.direction));
        }
    }

}

class Coordinate {
    int x;
    int y;
    int direction;

    public Coordinate(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}
