package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로 {

    static int[][] map;
    static int l;

    public static void main(String[] args) throws IOException {
        inputMapAndL();
    }

    private static void inputMapAndL() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        l = Integer.parseInt(token.nextToken());
        map = new int[n][n];

        for (int i=0; i<n; ++i) {
            StringTokenizer tokenizer =
                    new StringTokenizer(buffer.readLine());
            for (int z=0; z<n; ++z) {
                map[i][z] = Integer.parseInt(tokenizer.nextToken());
            }
        }

    }

}
