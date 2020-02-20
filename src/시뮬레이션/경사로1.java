package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로1 {

    static int[][] map;
    static int n;
    static int L;

    public static void main(String[] args) throws IOException {
        inputMap();
    }

    private static void inputMap() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        L = Integer.parseInt(token.nextToken());

        map = new int[n][n];
    }

}
