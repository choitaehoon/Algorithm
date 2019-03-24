package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 욕심쟁이판다 {

    //상 하 좌 우
    public static int[] dX = {-1,1,0,0};
    public static int[] dY = {0,0,-1,1};

    public static int max;
    public static int [][] dAray;
    public static int number;
    public static int [][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(buffer.readLine());
        array = new int[number][number];
        dAray = new int[number][number];

        for (int i=0; i<number; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int j=0; j<number; ++j)
                array[i][j] = Integer.parseInt(token.nextToken());
        }

        for (int i=0; i<number; ++i)
            for (int j=0; j<number; ++j)
                max = Math.max(max,go(i,j));

        System.out.println(max);
    }

    public static int go(int x, int y) {

        if (dAray[x][y] != 0)
            return dAray[x][y];

        //판다가 하루라도 먹은거니까
        dAray[x][y] = 1;

        for (int i=0; i<4; ++i) {

            //범위 벗어난 경우
            if (x+dX[i] < 0 || x+dX[i] >= number || y+dY[i] < 0 || y+dY[i] >= number )
                continue;

            if (array[x][y] < array[x+dX[i]][y+dY[i]])
                dAray[x][y] = Math.max(dAray[x][y], go(x+dX[i],y+dY[i])+1);
        }

        return dAray[x][y];
    }

}
