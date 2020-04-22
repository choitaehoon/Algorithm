package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {

    static int r;
    static int c;
    static String[][] array;
    static boolean[] isCheck;
    static int max;
    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        inputRC();
        recursive(0, 0, 1);
        System.out.println(max);
    }

    private static void recursive(int width, int high, int count) {
        max = Math.max(count, max);
        isCheck[array[width][high].charAt(0) - 'A'] = true;

        for (int i = 0; i < 4; ++i) {
            int xGo = width + xMove[i];
            int yGo = high + yMove[i];

            if (xGo < 0 || xGo >= r || yGo < 0 || yGo >= c || isCheck[array[xGo][yGo].charAt(0) - 'A'])
                continue;

            recursive(xGo, yGo, count + 1);
            isCheck[array[xGo][yGo].charAt(0) - 'A'] = false;
        }
    }

    private static void inputRC() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());
        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        array = new String[r][c];
        isCheck = new boolean[26];

        for (int i = 0; i < r; ++i) {
            String[] temp = buffer.readLine().split("");
            if (c >= 0)
                System.arraycopy(temp, 0, array[i], 0, c);
        }

    }


}
