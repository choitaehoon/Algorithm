package 미해결문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 토마토 {

    static int 가로;
    static int 세로;
    static int 상자의수;
    static int[] xMove;
    static int[] yMove;
    static int[][] array;
    static Queue<PointerLocation> queue = new LinkedList<>();
    static int sumCount = 0;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        세로 = Integer.parseInt(token.nextToken());
        가로 = Integer.parseInt(token.nextToken());
        상자의수 = Integer.parseInt(token.nextToken());
        array = new int[가로*상자의수][세로];

        xMove = new int[]{-1,1,0,0,-가로,가로};
        yMove = new int[]{0,0,-1,1,0,0};

        for (int i=0; i<가로*상자의수; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
            for (int j=0; j<세로; ++j) {
                int num = Integer.parseInt(tokenizer.nextToken());

                if (num == 1)
                    queue.offer(new PointerLocation(i,j));
                if (num == 0)
                    cnt ++;

                array[i][j] = num;
            }
        }

        dfs();

        System.out.println(Arrays.deepToString(array));
        System.out.println(sumCount);
    }

    private static int dfs() {

        while (!queue.isEmpty()) {
            int size = queue.size();
            PointerLocation pointerLocation = queue.poll();

            for (int q = 0; q< size; ++q) {
                int x = pointerLocation.x;
                int y = pointerLocation.y;

                for (int i=0; i< 6; ++i) {
                    int xGo = x + xMove[i];
                    int yGo = y + yMove[i];

                    if (xGo < 0 || xGo >= 가로*상자의수 || yGo < 0 || yGo >= 세로 || array[xGo][yGo] == -1 || array[xGo][yGo] > 0)
                        continue;

                        --cnt;
                        array[xGo][yGo] = sumCount;
                        queue.offer(new PointerLocation(xGo,yGo));


                    if (cnt == 0)
                        return sumCount;
                }
            }
            sumCount++;
        }

        return -1;
    }

}

class PointerLocation {
    int x;
    int y;

    public PointerLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}