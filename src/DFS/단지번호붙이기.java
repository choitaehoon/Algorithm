package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기 {

    static int n;
    static int[][] map;
    static boolean[][] check;
    static List<Integer> list = new ArrayList<>();
    static int[] xMove = {-1,0,1,0};
    static int[] yMove = {0,1,0,-1};
    static int sum = 1;

    public static void main(String[] args) throws IOException {
        inputN();
        actionMapSearch();
        printGo();
    }

    private static void inputN() throws IOException{
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
        map = new int[n][n];
        check = new boolean[n][n];

        for (int i=0; i<n; ++i) {
            String[] temp = buffer.readLine().split("");
            for (int j=0; j<n; ++j)
                map[i][j] = Integer.parseInt(temp[j]);
        }

    }

    private static void actionMapSearch() {

        for (int i=0; i<n; ++i)
            for (int j=0; j<n; ++j)
                if (!check[i][j] && map[i][j] == 1) {
                    actionMapSearch(i,j);
                    list.add(sum);
                    sum = 1;
                }
    }

    private static void actionMapSearch(int width, int vertical) {
        check[width][vertical] = true;

        for (int i=0; i<4; ++i) {
            int xGo = width + xMove[i];
            int yGo = vertical + yMove[i];

            if (xGo < 0 || xGo >=n || yGo < 0 || yGo >=n || check[xGo][yGo] || map[xGo][yGo] == 0)
                continue;

            sum++;
            actionMapSearch(xGo, yGo);
        }
    }

    private static void printGo() {
        System.out.println(list.size());
        Collections.sort(list);

        for (int i=0; i<list.size(); ++i)
            System.out.println(list.get(i));
    }

}
