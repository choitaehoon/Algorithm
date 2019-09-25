package 못푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 로봇청소기 {

    static int[][] area;
    static int horizon; //가로
    static int vertical; //세로
    static boolean[][] check;
    static int count;
    static int[] moveX = {0,1,0,-1};
    static int[] moveY = {-1,0,1,0};
    static int[] reverseX = {0,-1,0,1};
    static int[] reverseY = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        horizon = Integer.parseInt(token.nextToken());
        vertical = Integer.parseInt(token.nextToken());
        area = new int[horizon][vertical];
        check = new boolean[horizon][vertical];

        StringTokenizer coordinate = new StringTokenizer(buffer.readLine());

        //배열 삽입
        for (int i=0; i<horizon; ++i)
            insertArray(i,buffer.readLine());

        int x = Integer.parseInt(coordinate.nextToken());
        int y = Integer.parseInt(coordinate.nextToken());
        int d = Integer.parseInt(coordinate.nextToken());

        //현재 위치 청소
        presentCleaningGo(x,y);
        //로봇 청소
        robotCleaning(x,y,d,0);

        System.out.println(count);
    }

    //로봇 청소
    private static void robotCleaning(int x, int y, int d, int count) {

        int xMoveGo = x + moveX[d];
        int yMoveGo = y + moveY[d];

        //범위를 벗어나면
        if (xMoveGo < 0 || xMoveGo >= horizon || yMoveGo < 0 || yMoveGo >= vertical || count == 3)
            return;

        //청소 공간이 존재 하는지 체크
        if (!check[xMoveGo][yMoveGo] && area[xMoveGo][yMoveGo] != 1) {
            presentCleaningGo(xMoveGo,yMoveGo);
            robotCleaning(xMoveGo,yMoveGo, (d+1)%4,0);
        }
        //왼쪽 방향에 청소 할 공간이 없다면 그 방향으로 회전
        else if (check[xMoveGo][yMoveGo])
            robotCleaning(x,y,(d+1)%4, count + 1);
        //네 방향 모두 청소가 되어 있거나 벽인 경우 -> 바라보는 방향으로 한 칸 후진
       else if (isCleaning(x,y))
            robotCleaning(x+reverseX[d], y+reverseY[d], (d+1)%4, 0);
        //네 방향 모두 청소 되어 있거나 벽이면서 뒤로 후진 할 수 없는 경우
        else
            return;
    }

    //청소 되어 있는지 확인
    private static boolean isCleaning(int x, int y) {
        for (int i=0; i<4; ++i){
            int xMove = x + moveX[i];
            int yMove = y + moveY[i];

            if (xMove < 0 || xMove >= horizon || yMove < 0 || yMove >= vertical || check[xMove][yMove] || area[xMove][yMove] == 1)
                return true;
        }

        return false;
    }

    //현재 위치 청소
    private static void presentCleaningGo(int x, int y){
        //현재 위치 청소
            count++;
            check[x][y] = true;
            area[x][y] = 1;
    }

    //배열 삽입
    private static void insertArray(int index, String text) {
        StringTokenizer token = new StringTokenizer(text);
        for (int i=0; i<vertical; ++i)
            area[index][i] = Integer.parseInt(token.nextToken());
    }

}
