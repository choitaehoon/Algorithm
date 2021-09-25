package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거북이 {

    static int[] xMove = {0, 1, 0, -1};
    static int[] yMove = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < n; ++i) {
            String word = buffer.readLine();
            solution(word);
        }
    }

    private static void solution(String word) {
        int max_X = 0, max_Y = 0, min_X = 0, min_Y = 0;
        int direction = 0;
        int x = 0, y = 0;

        for (char nowWord : word.toCharArray()) {
            if (nowWord == 'F') {
                x += xMove[direction];
                y += yMove[direction];
            } else if (nowWord == 'B'){
                x -= xMove[direction];
                y -= yMove[direction];
            } else if (nowWord == 'L') {
                direction = (direction + 3) % 4;
            } else if (nowWord == 'R') {
                direction = (direction + 1) % 4;
            }

            max_X = Math.max(max_X, x);
            max_Y = Math.max(max_Y, y);
            min_X = Math.min(min_X, x);
            min_Y = Math.min(min_Y, y);
        }

        System.out.println(Math.abs(max_X - min_X) * Math.abs(max_Y - min_Y));
    }

}
