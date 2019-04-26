package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//재귀로 풀면 시간 초과.. 반복문 으로 다시 풀어야지
@SuppressWarnings("Duplicates")
public class 이동하기 {

    static int n;
    static int m;
    static int[][] array;
    static int[][] sumArray;
    static int[] xMove = {1,0,1};
    static int[] yMove = {0,1,1};
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        array = new int[n][m];
        sumArray = new int[n][m];

        for (int i=0; i<n; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
            for (int j=0; j<m; ++j)
                array[i][j] = Integer.parseInt(tokenizer.nextToken());
        }

        recursive(0,0,array[0][0]);
        System.out.println(max);
    }

    private static void recursive (int x, int y, int sum) {
        if (x == n-1 && y == m-1) {
            max = Math.max(max,sum);
            return;
        }

        if (sumArray[x][y] > 0)
            return;

        sumArray[x][y] = Math.max(sum,sumArray[x][y]);

        for (int i=0; i<3; ++i){
            int xGo = x + xMove[i];
            int yGo = y + yMove[i];

            if (xGo < 0 || xGo >= n || yGo < 0 || yGo >= m)
                continue;
            recursive(xGo,yGo,sum+array[xGo][yGo]);
        }

    }
}
