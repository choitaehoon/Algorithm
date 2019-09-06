package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 유기농배추 {

    static int x;
    static int y;
    static int cabbageNumber;
    static int[][] cabbage;
    static int count;
    static boolean[][] check;
    static int[] xMove = {-1,1,0,0};
    static int[] yMove = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            x = Integer.parseInt(token.nextToken());
            y = Integer.parseInt(token.nextToken());
            cabbageNumber = Integer.parseInt(token.nextToken());
            cabbage = new int[x][y];
            check = new boolean[x][y];
            count = 0;

            for (int j=0; j<cabbageNumber; ++j) {
                StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
                cabbage[Integer.parseInt(tokenizer.nextToken())][Integer.parseInt(tokenizer.nextToken())] = 1;
            }

            for (int h=0; h<x; ++h)
                for (int g=0; g<y; ++g)
                    if (!check[h][g] && cabbage[h][g] == 1) {
                        ++count;
                        dfs(h,g);
                    }

            System.out.println(count);
        }

    }

    private static void dfs(int xPresent, int yPresent) {
        check[xPresent][yPresent] = true;

        for (int i=0; i<4; ++i){
            int xGo = xPresent + xMove[i];
            int yGo = yPresent + yMove[i];

            if (xGo >= x || xGo < 0 || yGo >= y || yGo < 0 || check[xGo][yGo] || cabbage[xGo][yGo] == 0)
                continue;

            dfs(xGo,yGo);
        }

    }

}
