package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {

    static boolean[] alphabet = new boolean[26];
    static char[][] alphabetArray;

    //상 하 좌 우
    static int[] xMove = {-1,1,0,0};
    static int[] yMove = {0,0,-1,1};

    static int c;
    static int r;

    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        c = Integer.parseInt(token.nextToken());
        r = Integer.parseInt(token.nextToken());
        alphabetArray = new char[c][r];

        for (int i=0; i<c; ++i) {
            char[] characters = buffer.readLine().toCharArray();
            for (int j=0; j<r; ++j)
                alphabetArray[i][j] = characters[j];
        }

        dfs(0,0,1);
        System.out.println(max);
    }

    static void dfs (int x, int y, int sum) {
        max = Math.max(max,sum);

        alphabet[alphabetArray[x][y] - 'A'] = true;

        for (int i=0; i<4; ++i) {
            int xGo = x + xMove[i];
            int yGo = y + yMove[i];

            if (xGo < 0 || xGo >= c || yGo < 0 || yGo >= r || alphabet[alphabetArray[xGo][yGo]-'A'])
                continue;

            dfs(xGo,yGo,sum+1);
            alphabet[alphabetArray[xGo][yGo]-'A'] = false;
        }
    }

}
