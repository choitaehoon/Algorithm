package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약 {

    static int okay;
    static int no;
    static boolean[][] visit;
    static int[] xMove = {0, 0, 1, -1};
    static int[] yMove = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        char[][] array = new char[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            char[] input = buffer.readLine().toCharArray();
            for (int k = 0; k < n; ++k)
                array[i][k] = input[k];
        }

        solution(array, n);
    }

    private static void solution(char[][] array, int n) {
        personRG(array, n);
        clear(n);
        person(array, n);

        System.out.println(no + " " + okay);
    }

    /*
        RG를 같이 보는 경우(적록색약인 사람)
    */
    private static void personRG(char[][] array, int n) {
        for (int i = 0; i < n; ++i)
            for (int k = 0; k < n; ++k) {
                if (!visit[i][k]) {
                    ++okay;
                    rgDFS(i, k, array, n);
                }
            }
    }

    private static void rgDFS(int x, int y, char[][] array, int n) {
        visit[x][y] = true;

        for (int i = 0; i < 4; ++i) {
            int xGo = x + xMove[i];
            int yGo = y + yMove[i];

            if (xGo < 0 || xGo >= n || yGo < 0 || yGo >= n
                    || visit[xGo][yGo] || (array[x][y] == 'R' && array[xGo][yGo] == 'B')
                    ||(array[x][y] == 'B' && array[xGo][yGo] == 'R')
                    ||(array[x][y] == 'B' && array[xGo][yGo] == 'G')
                    ||(array[x][y] == 'G' && array[xGo][yGo] == 'B'))
                continue;

            rgDFS(xGo, yGo, array, n);
        }
    }

    private static void clear(int n) {
        for (int i = 0; i < n; ++i)
            for (int k = 0; k < n; ++k)
                visit[i][k] = false;
    }

    /*
        적록색약이 아닌 사람
    */
    private static void person(char[][] array, int n) {
        for (int i = 0; i < n; ++i)
            for (int k = 0; k < n; ++k) {
                if (!visit[i][k]) {
                    ++no;
                    dfs(i, k, array, n);
                }
            }
    }

    private static void dfs(int x, int y, char[][] array, int n) {
        visit[x][y] = true;

        for (int i = 0; i < 4; ++i) {
            int xGo = x + xMove[i];
            int yGo = y + yMove[i];

            if (xGo < 0 || xGo >= n || yGo < 0 || yGo >= n
                    || visit[xGo][yGo] || array[x][y] != array[xGo][yGo])
                continue;

            dfs(xGo, yGo, array, n);
        }
    }
}
