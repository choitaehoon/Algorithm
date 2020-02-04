package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

    static int[] xMove = {-1,0,1,0};
    static int[] yMove = {0,1,0,-1};
    static boolean[][] check;
    static Queue<Tomato> queue = new LinkedList<>();
    static int[][] tomato;
    static int[][] storeTomato;
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        y = Integer.parseInt(token.nextToken());
        x = Integer.parseInt(token.nextToken());

        declareArrays();

        for (int i=0; i<x; ++i) {
            inputArray(i, buffer.readLine().split(" "));
        }

        checkTomato();
        System.out.println(searchTomato());
    }

    private static void declareArrays() {
        tomato = new int[x][y];
        check = new boolean[x][y];
        storeTomato = new int[x][y];
    }

    private static void inputArray(int x, String[] input) {
        for (int i=0; i<y; ++i) {
            inputNumberOneQueue(input[i], x, i);
            tomato[x][i] = Integer.parseInt(input[i]);
        }
    }

    private static void inputNumberOneQueue(String input, int x, int y) {
        if (input.equals("1")) {
            storeTomato[x][y] = 1;
            check[x][y] = true;
            queue.offer(new Tomato(x, y));
        } else if (input.equals("-1")) {
            storeTomato[x][y] = -1;
        }
    }

    private static void checkTomato() {
        while (!queue.isEmpty()) {
            tomatoGo(queue.poll());
        }
    }

    private static void tomatoGo(Tomato poll) {
        for (int i=0; i<4; ++i) {
            int xGo = poll.x + xMove[i];
            int yGo = poll.y + yMove[i];
            if (xGo < 0 || xGo >= x || yGo < 0 || yGo >= y || check[xGo][yGo] || tomato[xGo][yGo] < 0)
                continue;

            check[xGo][yGo] = true;
            storeTomato[xGo][yGo] = storeTomato[poll.x][poll.y] + 1;
            queue.offer(new Tomato(xGo, yGo));
        }
    }

    private static int searchTomato() {
        int max = 0;

        for (int i=0; i<x; ++i)
            for (int j=0; j<y; ++j) {
                if (storeTomato[i][j] == 0) {
                    return -1;
                } else {
                    max = Math.max(max, storeTomato[i][j]);
                }
            }

        return max-1;
    }

}

class Tomato {
    int x;
    int y;

    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
