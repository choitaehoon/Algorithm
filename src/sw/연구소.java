package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연구소 {

    static int n;
    static int m;
    static int[][] givenArray;
    static int[][] moveArray;
    static List<Point> list = new ArrayList<>();
    static int max;
    static int[] moveX = {-1,1,0,0};
    static int[] moveY = {0,0,-1,1};

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        givenArray = new int[n][m];
        moveArray = new int[n][m];

        for (int i=0; i<n; ++i) {
            StringTokenizer givenArrayToken = new StringTokenizer(buffer.readLine());
            for (int j=0; j<m; ++j) {
                int number = Integer.parseInt(givenArrayToken.nextToken());

                if (number == 2)
                    list.add(new Point(i,j));

                givenArray[i][j] = number;
            }
        }

        threeWall(0,0);
        System.out.println(max);
    }

    static void threeWall(int start, int depth) {
        if (depth == 3) {

            copyMap();

            for (Point point : list)
                spreadVirus(point.x, point.y);

            max = Math.max(max, safeArea());
            return;
        }

        for (int i=start; i<n*m; ++i) {
            int x = i/m;
            int y = i%m;

            if (givenArray[x][y] == 0) {
                givenArray[x][y] = 1;
                threeWall(i+1, depth+1);
                givenArray[x][y] = 0;
            }
        }
    }

    static void copyMap() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                moveArray[i][j] = givenArray[i][j];
            }
        }
    }

    static void spreadVirus (int x, int y) {
        for (int i=0; i<4; ++i) {
            int pointX = x+moveX[i];
            int pointY = y+moveY[i];

            if (0<= pointX && pointX <n && 0<= pointY && pointY < m && moveArray[pointX][pointY] == 0) {
                moveArray[pointX][pointY] = 2;
                spreadVirus(pointX, pointY);
            }

        }
    }

    static int safeArea() {
        int sum = 0;
        for (int i=0; i<n; ++i)
            for (int j=0; j<m; ++j)
                if (moveArray[i][j] == 0)
                    ++sum;

        return sum;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
