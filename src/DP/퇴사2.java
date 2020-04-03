package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사2 {

    static int day;
    static int[][] array;
    static int[] t;

    public static void main(String[] args) throws IOException {
        inputDayAndArray();
        dpAction();
    }

    private static void dpAction() {

        for (int i=0; i<day; ++i) {
            t[i + array[i][0]] = Math.max(t[i + array[i][0]], array[i][1] + t[i]);
            t[i + 1] = Math.max(t[i + 1], t[i]);
        }

        System.out.println(t[day]);
    }

    private static void inputDayAndArray() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        day = Integer.parseInt(buffer.readLine());

        array = new int[day][2];
        t = new int[2000];

        for (int i=0; i<day; ++i) {
            StringTokenizer token =
                    new StringTokenizer(buffer.readLine());

            array[i][0] = Integer.parseInt(token.nextToken());
            array[i][1] = Integer.parseInt(token.nextToken());
        }
    }

}
