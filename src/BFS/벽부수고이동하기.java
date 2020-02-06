package BFS;

import java.io.*;
import java.util.*;

public class 벽부수고이동하기 {

    static int width;
    static int vertical;
    static int[] xMove = {-1,0,1,0};
    static int[] yMove = {0,1,0,-1};
    static Queue<WallCoordinate> queue = new LinkedList<>();
    static int[][] map;
    static int[][][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        declareMapAndWidthAndVertexDist(token);
        inputMap(buffer);
        checkQueue();
        shortestPath();
    }

    private static void declareMapAndWidthAndVertexDist(StringTokenizer token) {
        width = Integer.parseInt(token.nextToken());
        vertical = Integer.parseInt(token.nextToken());

        map = new int[width][vertical];
        dist = new int[width][vertical][2];
        dist[0][0][0] = 1;
        queue.offer(new WallCoordinate(0,0,0));
    }

    private static void inputMap(BufferedReader buffer) throws IOException {
        for (int i = 0; i< width; ++i) {
            String[] wall = buffer.readLine().split("");
            for (int j = 0; j< vertical; ++j) {
                map[i][j] = Integer.parseInt(wall[j]);
            }
        }
    }

    private static void checkQueue() {
        while (!queue.isEmpty()) {
            WallCoordinate wall = queue.poll();
            int status = wall.status;

            for (int i = 0; i<4; ++i) {
                int xGo = wall.x + xMove[i];
                int yGo = wall.y + yMove[i];

                if (xGo < 0 || xGo >=width || yGo < 0 || yGo >= vertical)
                    continue;

                if (map[xGo][yGo] == 0 && dist[xGo][yGo][status] == 0) {
                    dist[xGo][yGo][status] = dist[wall.x][wall.y][status] + 1;
                    queue.offer(new WallCoordinate(xGo, yGo, status));
                }

                if (status == 0 && map[xGo][yGo] == 1 && dist[xGo][yGo][status+1] == 0) {
                    dist[xGo][yGo][status+1] = dist[wall.x][wall.y][status] + 1;
                    queue.offer(new WallCoordinate(xGo, yGo, status+1));
                }
            }
        }
    }

    private static void shortestPath() {
        if (dist[width-1][vertical-1][0] != 0 && dist[width-1][vertical-1][1] != 0) {
            System.out.println(Math.min(dist[width-1][vertical-1][0], dist[width-1][vertical-1][1]));
        } else if (dist[width-1][vertical-1][0] != 0) {
            System.out.println(dist[width-1][vertical-1][0]);
        } else if (dist[width-1][vertical-1][1] != 0) {
            System.out.println(dist[width-1][vertical-1][1]);
        } else {
            System.out.println(-1);
        }
    }

}

class WallCoordinate {
    int x;
    int y;
    int status;

    public WallCoordinate(int x, int y, int status) {
        this.x = x;
        this.y = y;
        this.status = status;
    }
}