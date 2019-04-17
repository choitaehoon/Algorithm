package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 로봇청소기다시풀기 {

    static int[][] givenArray;
    static int n;
    static int m;
    static Queue<Pointer> queue = new LinkedList<>();

    //북동남서
    static int[] xMove = {-1,0,1,0};
    static int[] yMove = {0,1,0,-1};
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        givenArray = new int[n][m];

        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        queue.offer(new Pointer(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())
                            ,Integer.parseInt(tokenizer.nextToken())));

        //배열에 값 삽입
        for (int i=0; i<n; ++i) {
            StringTokenizer tokenArray = new StringTokenizer(buffer.readLine());
            for (int j=0; j<m; ++j)
                givenArray[i][j] = Integer.parseInt(tokenArray.nextToken());
        }

        cleaningRobot();
        System.out.println(sum);
    }

    static void cleaningRobot () {
        while (!queue.isEmpty()) {
            Pointer pointer = queue.poll();

            //청소 할 수 있다면 청소하기
            if (givenArray[pointer.x][pointer.y] == 0) {
                givenArray[pointer.x][pointer.y] = 2;
                ++sum;
            }

            for (int i=0; i<4; ++i) {
                int x = pointer.x + xMove[(pointer.direction+3 - i)%4];
                int y = pointer.y + yMove[(pointer.direction+3 - i)%4];

                //범위 안에 든다면
                if (0 > x || x >= n || 0 > y || y >= m  || givenArray[x][y] != 0 )
                    continue;

                queue.offer(new Pointer(x,y,(pointer.direction+3-i)%4));
                break;
            }

            //네 방향이 이미 되어 있는 경우
            while (queue.isEmpty()) {
                int x = pointer.x + xMove[(pointer.direction+2)%4];
                int y = pointer.y + yMove[(pointer.direction+2)%4];

                if (0 > x || x >= n || 0 > y || y >= m  || givenArray[x][y] == 1 )
                    break;

                queue.offer(new Pointer(x,y,pointer.direction));
            }

        }
    }
}

class Pointer{
    int x;
    int y;
    int direction;

    public Pointer(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}
