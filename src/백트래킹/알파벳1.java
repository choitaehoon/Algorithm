package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳1 {

    static char[][] alphabet;
    static boolean[] isAlphabet = new boolean[26];
    static int max;
    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        x = Integer.parseInt(token.nextToken());
        y = Integer.parseInt(token.nextToken());
        alphabet = new char[x][y];

        for (int i = 0; i < x; ++i) {
            String word = buffer.readLine();
            for (int k = 0; k < y; ++k)
                alphabet[i][k] = word.charAt(k);
        }


        maxCountCheck(0, 0, 1);
        System.out.println(max);

    }

    private static void maxCountCheck(int xIndex, int yIndex, int count) {
        max = Math.max(max, count);
        isAlphabet[alphabet[xIndex][yIndex] - 'A'] = true;

        for (int i = 0; i < 4; ++i) {
            int xGo = xIndex + xMove[i];
            int yGo = yIndex + yMove[i];

            if (xGo < 0 || xGo >= x || yGo < 0 || yGo >= y || isAlphabet[alphabet[xGo][yGo] - 'A'])
                continue;

            maxCountCheck(xGo, yGo, count + 1);
            isAlphabet[alphabet[xGo][yGo] - 'A'] = false;
        }

    }

}
