package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 스도쿠 {

    static Queue<Pair> queue = new LinkedList<>();
    static int[][] array = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        // 0의 위치 삽입
        for (int i = 0; i < 9; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int j = 0; j < 9; ++j) {
                int number = Integer.parseInt(token.nextToken());
                if (number == 0)
                    queue.offer(new Pair(i, j));
                array[i][j] = number;
            }
        }

        searchZero();

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j)
                builder.append(array[i][j]).append(" ");
            builder.append("\n");
        }

        System.out.println(builder);
    }

    static void searchZero () {

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            int horizon = horizontalInspection(pair.x);
            if (horizon != -1) {
                array[pair.x][pair.y] = horizon;
                continue;
            }

            int vertical = verticalInspection(pair.y);
            if (vertical != -1) {
                array[pair.x][pair.y] = vertical;
                continue;
            }

            int triangle = triangleCheck(pair.x, pair.y);
            if (triangle != -1)
                array[pair.x][pair.y] = triangle;

        }

    }

    //가로 검사
     static int horizontalInspection(int x) {
        boolean[] check = new boolean[10];
        int cnt = 0;

        for (int i = 0; i < 9; ++i) {
            if (array[x][i] != 0)
                check[array[x][i]] = true;

            else if (array[x][i] == 0)
                cnt++;

            if (cnt == 2)
                return -1;

        }

        int number = 0;
        for (int i=1; i<10; ++i)
            if (!check[i]) {
                number = i;
                break;
            }


        return number;
    }

    //세로 검사
    static int verticalInspection (int y) {
        boolean[] check = new boolean[10];
        int cnt = 0;

        for (int i=0; i<9; ++i) {
            if (array[i][y] != 0)
                check[array[i][y]] = true;

            else if (array[i][y] == 0)
                cnt++;

            if (cnt == 2)
                return -1;
        }

        int number = 0;
        for (int i=1; i<10; ++i)
            if (!check[i]) {
                number = i;
                break;
            }

        return number;
    }

    //삼각형 검사
    static int triangleCheck (int x, int y) {
        boolean[] check = new boolean[10];
        int cnt = 0;

        x = triangleIndexRange(x);
        y = triangleIndexRange(y);

        int xIndex = x+2;
        int yIndex = y+2;

        for (int i=x; i<=xIndex; ++i)
            for (int j=y; j<=yIndex; ++j) {
                if (array[i][j] != 0)
                    check[array[i][j]] = true;

                else if (array[i][j] == 0)
                    cnt++;

                if (cnt == 2)
                    return -1;
            }

        int number = 0;
        System.out.println();
        for (int i=1; i<10; ++i)
            if (!check[i]) {
                number = i;
                break;
            }

        return number;
    }

    static int triangleIndexRange (int index) {
        return index/3*3;
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