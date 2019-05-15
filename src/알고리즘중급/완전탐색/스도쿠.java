package 알고리즘중급.완전탐색;

import java.io.*;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 스도쿠 {

    static final int n = 9;
    static int[][] array = new int[n][n];
    static boolean[][][] check = new boolean[3][n][10];
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<n; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int j=0; j<n; ++j) {
                array[i][j] = Integer.parseInt(token.nextToken());
                if (array[i][j] != 0) {
                    check[0][i][array[i][j]] = true;
                    check[1][j][array[i][j]] = true;
                    check[2][square(i,j)][array[i][j]] = true;
                }
            }
        }

        go(0);

        writer.close();
    }

    static int square(int x, int y) {
        return (x/3)*3 + (y/3);
    }

    static boolean go(int index) throws IOException {
        int x = index/n;
        int y = index%n;

        if (index == 81) {
            print();
            return true;
        }

        if (array[x][y] != 0) {
            return go(index+1);
        }

        else {
            for (int i=1; i<=9; ++i) {
                if (!check[0][x][i] && !check[1][y][i] && !check[2][square(x,y)][i]) {
                    check[0][x][i] = check[1][y][i] = check[2][square(x,y)][i] = true;
                    array[x][y] = i;
                    if (go(index+1))
                        return true;
                    array[x][y] = 0;
                    check[0][x][i] = check[1][y][i] = check[2][square(x,y)][i] = false;
                }
            }

            return false;
        }
    }


    static void print() throws IOException {
        for (int i=0; i<n; ++i) {
            for (int j=0; j<n; ++j)
                    writer.write(array[i][j]+" ");
            writer.write("\n");
        }
    }
}
