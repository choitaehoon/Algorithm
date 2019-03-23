package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        int[][] array = new int[number+1][3];
        int[][] temp = new int[number+1][3];

        for (int i=1; i<=number; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int j=0; j<3; ++j)
                array[i][j] = Integer.parseInt(token.nextToken());
        }

        for (int i=1; i<=number; ++i) {
            temp[i][0] = Math.min(temp[i-1][1],temp[i-1][2]) + array[i][0];
            temp[i][1] = Math.min(temp[i-1][0],temp[i-1][2]) + array[i][1];
            temp[i][2] = Math.min(temp[i-1][1],temp[i-1][0]) + array[i][2];
        }

        System.out.println( Math.min(Math.min( temp[number][0], temp[number][1]), temp[number][2]));
    }
}
