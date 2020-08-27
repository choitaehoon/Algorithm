package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동 {

    static int[] xMove = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] yMove = {-1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < givenNumber; ++i) {
            int chessLen = Integer.parseInt(buffer.readLine());
            boolean[][] chess = new boolean[chessLen][chessLen];

            StringTokenizer startToken = new StringTokenizer(buffer.readLine());
            StringTokenizer endToken = new StringTokenizer(buffer.readLine());

            int startX = Integer.parseInt(startToken.nextToken());
            int startY = Integer.parseInt(startToken.nextToken());

            int endX = Integer.parseInt(endToken.nextToken());
            int endY = Integer.parseInt(endToken.nextToken());

            System.out.println(chessBFS(startX, startY, endX, endY, chess));
        }

    }

    private static int chessBFS(int startX, int startY, int endX, int endY, boolean[][] chess) {
        Queue<Pointer> chessQueue = new LinkedList<>();
        chessQueue.offer(new Pointer(startX, startY));
        int[][] storeChess = new int[chess.length][chess.length];
        int result = 0;

        while (!chessQueue.isEmpty()) {
            Pointer nowPointer = chessQueue.poll();

            if (nowPointer.x == endX && nowPointer.y == endY) {
                result = storeChess[endX][endY];
                break;
            }

            for (int i = 0; i < 8; ++i) {
                int xGo = nowPointer.x + xMove[i];
                int yGo = nowPointer.y + yMove[i];

                if (xGo < 0 || xGo >= chess.length || yGo < 0 || yGo >= chess.length || chess[xGo][yGo])
                    continue;

                chess[xGo][yGo] = true;
                storeChess[xGo][yGo] = storeChess[nowPointer.x][nowPointer.y] + 1;
                chessQueue.offer(new Pointer(xGo, yGo));
            }

        }

        return result;
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