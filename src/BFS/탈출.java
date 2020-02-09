package BFS;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*
 * 배열에 삽입 할 때 S 나오면 queue 삽입 -> *, X 나올때 water 삽입 // okay
 * water 위, 아래, 좌, 우 탐색 후 queue 돌기 //
 *
 * */

@SuppressWarnings("all")
public class 탈출 {

    static String[][] map;
    static boolean[][] check;
    static Queue<Pointer> queue = new LinkedList<>();
    static Queue<Pointer> water = new LinkedList<>();
    static int[] xMove = {-1,0,1,0};
    static int[] yMove = {0,1,0,-1};
    static int xS;
    static int yS;
    static int[][] dist;
    static int width;
    static int vertical;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        declareMapAndWidthAndVertical(token);
        inputMap(buffer);
        searchQueue();
        System.out.println(Arrays.deepToString(dist));
    }

    private static void declareMapAndWidthAndVertical(StringTokenizer token) {
        width = Integer.parseInt(token.nextToken());
        vertical = Integer.parseInt(token.nextToken());

        map = new String[width][vertical];
        check = new boolean[width][vertical];
        dist = new int[width][vertical];
    }

    private static void inputMap(BufferedReader buffer) throws IOException {
        for (int i=0; i<width; ++i) {
            String[] input = buffer.readLine().split("");
            for (int j=0; j<vertical; ++j) {
                checkQueueAndWater(input[j], i, j);
            }
        }
    }

    private static void checkQueueAndWater(String hurdle, int x, int y) {
        switch (hurdle) {
            case "*":
                water.offer(new Pointer(x, y));
                check[x][y] = true;
                break;
            case "X":
                check[x][y] = true;
                break;
            case "S":
                queue.offer(new Pointer(x, y));
                check[x][y] = true;
                break;
            case "D":
                xS = x;
                yS = y;
                break;
        }
    }

    private static void searchQueue() {
        while (!queue.isEmpty()) {
            searchWater();
            searchStartGo(queue.poll());
        }
    }

    private static void searchWater() {
        Pointer pointer = water.poll();

        if (pointer == null)
            return;

        for (int i=0; i<4; ++i) {
            int xGo = pointer.x + xMove[i];
            int yGo = pointer.y + yMove[i];

            if (xGo < 0 || xGo >= width || yGo < 0 || yGo >= vertical ||
                    check[xGo][yGo] || (xGo == xS && yGo == yS)) {
                continue;
            }

            check[xGo][yGo] = true;
            water.offer(new Pointer(xGo, yGo));
        }
    }

    private static void searchStartGo(Pointer start) {
        for (int i=0; i<4; ++i) {
            int xGo = start.x + xMove[i];
            int yGo = start.y + yMove[i];

            if (xGo < 0 || xGo >= width || yGo < 0 || yGo >= vertical || check[xGo][yGo])
                continue;

            check[xGo][yGo] = true;
            dist[xGo][yGo] = dist[start.x][start.y] + 1;
            queue.offer(new Pointer(xGo, yGo));
        }
    }

}

class Pointer {
    int x;
    int y;

    public Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
