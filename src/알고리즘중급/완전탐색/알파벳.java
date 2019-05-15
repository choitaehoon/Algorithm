package 알고리즘중급.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 알파벳 {

    static int width;
    static int vertical;
    static int[] xMove = {-1,1,0,0};
    static int[] yMove = {0,0,-1,1};
    static char[][] store;
    static int sum = 0;
    static boolean[] check;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        width = Integer.parseInt(token.nextToken());
        vertical = Integer.parseInt(token.nextToken());
        store = new char[width][vertical];
        check = new boolean[26];

        for (int i=0; i<width; ++i) {
            char[] temp = buffer.readLine().toCharArray();
            if (vertical >= 0)
                System.arraycopy(temp, 0, store[i], 0, vertical);
        }

        recursive(0,0,1);

        System.out.println(max);
    }

    private static void recursive(int x, int y, int sum) {
        max = Math.max(max,sum);
        check[store[x][y] - 65] = true;

        for (int i=0; i<4; ++i) {
            int xGo = x + xMove[i];
            int yGo = y + yMove[i];

            if (xGo >= width || xGo < 0 || yGo >= vertical || yGo < 0 || check[store[xGo][yGo] - 65])
                continue;

            recursive(xGo,yGo, sum+1);
            check[store[xGo][yGo] - 65] = false;
        }

    }

}
