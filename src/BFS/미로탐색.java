package BFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {

    static boolean [][] check;
    static int[][] storeWeight;
    static int[][] maze;
    static int[] xMove = {-1,0,1,0};
    static int[] yMove = {0,1,0,-1};
    static Queue<MazeMove> queue = new LinkedList<>();
    static int x;
    static int y;

    public static void main(String ...arg) throws IOException {

        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        x = Integer.parseInt(token.nextToken());
        y = Integer.parseInt(token.nextToken());

        arrayDeclare();

        for (int i=0; i<x; ++i) {
            mazeInputArray(i, buffer.readLine().split(""));
        }

        circleMaze();
        System.out.println(storeWeight[x-1][y-1]);
    }

    private static void arrayDeclare() {
        check = new boolean[x][y];
        storeWeight = new int[x][y];
        storeWeight[0][0] = 1;
        maze = new int[x][y];
    }

    private static void mazeInputArray(int width, String ...mazeInput) {
        for (int i=0; i<y; ++i)
            maze[width][i] = Integer.parseInt(mazeInput[i]);
    }

    private static void circleMaze() {
        queue.offer(new MazeMove(0,0));

        while (!queue.isEmpty()) {
            MazeMove mazeMove = queue.poll();
            checkMazeMove(mazeMove);
        }
    }

    private static void checkMazeMove(MazeMove mazeMove) {
        for (int i=0; i<4; ++i) {
            int xGo = mazeMove.xMaze + xMove[i];
            int yGo = mazeMove.yMaze + yMove[i];

            if (xGo < 0 || xGo >= x || yGo < 0 || yGo >= y || check[xGo][yGo] || maze[xGo][yGo] == 0)
                continue;

            queue.offer(new MazeMove(xGo, yGo));
            check[xGo][yGo] = true;
            storeWeight[xGo][yGo] = storeWeight[mazeMove.xMaze][mazeMove.yMaze] + 1;
        }
    }

}

class MazeMove {
    int xMaze;
    int yMaze;

    public MazeMove(int xMaze, int yMaze) {
        this.xMaze = xMaze;
        this.yMaze = yMaze;
    }
}