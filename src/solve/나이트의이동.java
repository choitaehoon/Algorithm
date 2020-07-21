package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동 {

    static int givenNumber;
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static int[] xMove = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] yMove = {-1, 1, 2, 2, 1, -1, -2, -2};
    static boolean[][] isGo;
    static Queue<Pointer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        isGo = new boolean[givenNumber][givenNumber];
        StringTokenizer tokenOne = new StringTokenizer(buffer.readLine());
        StringTokenizer tokenTwo = new StringTokenizer(buffer.readLine());

        startX = Integer.parseInt(tokenOne.nextToken());
        startY = Integer.parseInt(tokenOne.nextToken());

        endX = Integer.parseInt(tokenTwo.nextToken());
        endY = Integer.parseInt(tokenTwo.nextToken());

        isGo[startX][startY] = true;
        queue.offer(new Pointer(startX, startY));
        searchEnd();
    }

    private static void searchEnd() {
        int count = 0;

        loop : while (true) {
            int len = queue.size();
            if(len != 0) {
                for (int i = 0; i < len; ++i){
                    Pointer nowPointer = queue.poll();
                    assert nowPointer != null;
                    int nowX = nowPointer.x;
                    int nowY = nowPointer.y;

                    if (nowX == endX && nowY == endY) {
                        break loop;
                    }

                    for (int k = 0; k < 8; ++k) {
                        int nextX = nowX + xMove[k];
                        int nextY = nowY + yMove[k];

                        if (nextX < 0 || nextX >= givenNumber || nextY < 0 || nextY >= givenNumber || isGo[nextX][nextY])
                            continue;

                        isGo[nextX][nextY] = true;
                        queue.offer(new Pointer(nextX, nextY));
                    }

                }
            } else
                break;
            ++count;
        }

        System.out.println(count);

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
