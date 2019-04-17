package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//다시 풀기
@SuppressWarnings("Duplicates")
public class 로봇청소기 {

    static int[][] givenArray;

    static int[] xMove = {0,-1,0,1};
    static int[] yMove = {-1,0,1,0};
    static Queue<PointCheck> queue = new LinkedList<>();
    static boolean [][] check;
    static int sum;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        givenArray = new int[n+1][m+1];
        check = new boolean[n+1][m+1];

        StringTokenizer givenNumber = new StringTokenizer(buffer.readLine());
        queue.offer( new PointCheck(Integer.parseInt(givenNumber.nextToken()), Integer.parseInt(givenNumber.nextToken()),
                                    Integer.parseInt(givenNumber.nextToken())) );

        for (int i=1; i<=n; ++i) {
            StringTokenizer given = new StringTokenizer(buffer.readLine());
            for (int j=1; j<=m; ++j)
                givenArray[i][j] = Integer.parseInt(given.nextToken());
        }

        robotClean();
        System.out.println(sum);
    }

    static void robotClean () {

        while (!queue.isEmpty()) {
            PointCheck pointCheck = queue.poll();
            check[pointCheck.x][pointCheck.y] = true;
            boolean flag = false;
            ++sum;

            for (int i=0; i<4; ++i) {
                int x = pointCheck.x + xMove[i];
                int y = pointCheck.y + yMove[i];

                if (0 < x || x <= n || y < 0 || y <= m || !check[x][y]) {
                    queue.offer(new PointCheck(x,y,(i+2)%4));
                    flag = true;
                }
            }

            if (!flag) {
                boolean che = false;
                for (int i = 0; i<4; ++i) {
                    int x = pointCheck.x + xMove[i];
                    int y = pointCheck.y + yMove[i];

                    if ((0 < x && x <= n && y < 0 && y <= m ) ||  check[x][y] || givenArray[x][y] == 1) {
                        che = true;
                        break;
                    }

                }

                if (che) {

                }

            }
        }


    }

}

class PointCheck {
    int x;
    int y;
    int direction;

    public PointCheck(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}