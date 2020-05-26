package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자리배정 {

    static int personStand;
    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static int height;
    static int width;
    static int x;
    static int y;
    static boolean[][] isCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        height = Integer.parseInt(token.nextToken());
        width = Integer.parseInt(token.nextToken());
        isCheck = new boolean[width][height];
        personStand = Integer.parseInt(buffer.readLine());
        x = width - 1;

        if (width * height < personStand) {
            System.out.println(0);
            return;
        }

        assignSearch();
        System.out.println((y+1)+" "+(width-x));
    }

    public static void assignSearch() {
        int countGo = 1;
        int location = 0;
        int preX;
        int preY;

        while (personStand != countGo) {
            preX = x;
            preY = y;
            isCheck[preX][preY] = true;

            x = x + xMove[location];
            y = y + yMove[location];

            if(x < 0 || x >= width || y < 0 || y >= height || isCheck[x][y]) {
                location = (location + 1) % 4;
                x = preX;
                y = preY;
                continue;
            }

            ++countGo;
ㅈ
        }

    }

}
