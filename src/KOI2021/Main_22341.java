package KOI2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_22341 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());

        int x = n;
        int y = n;

        for (int i = 0; i < c; ++i) {
            StringTokenizer now = new StringTokenizer(buffer.readLine());
            int nowX = Integer.parseInt(now.nextToken());
            int nowY = Integer.parseInt(now.nextToken());

            if (x <= nowX || y <= nowY) {
                continue;
            }

            int row = nowX * y;
            int column = x * nowY;

            if (row > column) {
                x = nowX;
            } else if (row < column) {
                y = nowY;
            } else {
                x = nowX;
            }

        }

        System.out.println(x * y);
    }

}
