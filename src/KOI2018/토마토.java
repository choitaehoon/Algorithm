package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

    static int m,n,h;
    static int[][] tomato;
    static boolean[][] checkTomato;
    static int longTime = 1;
    static Queue<Pair> queue = new LinkedList<>();

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        m = Integer.parseInt(token.nextToken());
        n = Integer.parseInt(token.nextToken());
        h = Integer.parseInt(token.nextToken());
        tomato = new int[n*h][m];
        checkTomato = new boolean[n*h][m];

        //상 하 좌 우
        int[] xArray = {-1,1,0,0,-n,+n};
        int[] yArray = {0,0,-1,1,0,0};

        for (int i= 0; i<n*h; ++i) {
            StringTokenizer tomatoInput = new StringTokenizer(buffer.readLine());
            for (int j=0; j<m; ++j) {
                int number = Integer.parseInt(tomatoInput.nextToken());
                if (number == 1) {
                    queue.offer(new Pair(i,j));
                    checkTomato[i][j] = true;
                }
                tomato[i][j] = number;
            }
        }

            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                int x = pair.x;
                int y = pair.y;

                for (int i=0; i<6; ++i) {
                    if (x+xArray[i] < 0 || y+yArray[i] < 0 || x+xArray[i] >= n*h || y+yArray[i] >= m
                            || checkTomato[x+xArray[i]][y+yArray[i]] || tomato[x+xArray[i]][y+yArray[i]] == -1)
                        continue;

                    queue.offer(new Pair(x+xArray[i],y+yArray[i]));
                    tomato[x+xArray[i]][y+yArray[i]] = longTime;
                    checkTomato[x+xArray[i]][y+yArray[i]] = true;
                }
                ++longTime;
            }

        System.out.println(Arrays.deepToString(tomato));
    }
}
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}