package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * n극 : 0 / s극 : 1
 * 방향 : 1 / 반 시계 방향 : -1
 */
public class 톱니바퀴 {

    static int[][] wheel = new int[4][8];
    static int givenNumber;
    static int[] calculate = {1,2,4,8};

    public static void main(String[] args) throws IOException {
        inputWheel();
        actionWheel();
        printWheel();
    }

    private static void inputWheel() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<4; ++i) {
            String[] array = buffer.readLine().split("");
            for (int j=0; j<8; ++j) {
                wheel[i][j] = Integer.parseInt(array[j]);
            }
        }

        givenNumber = Integer.parseInt(buffer.readLine());

    }

    private static void actionWheel() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token =
                    new StringTokenizer(buffer.readLine());

            int wheelNumber = Integer.parseInt(token.nextToken());
            int way = Integer.parseInt(token.nextToken());

            actionWheel(wheelNumber-1, way);
        }
    }

    private static void actionWheel(int wheelNumber, int way) {
        actionLeft(wheelNumber-1, -way);
        actionRight(wheelNumber+1, -way);
        rotation(wheelNumber, way);
    }

    private static void actionLeft(int wheelNumber, int way) {
        if (wheelNumber <= 0)
            return;

        if (wheel[wheelNumber-1][2] != wheel[wheelNumber][6]) {
            actionLeft(wheelNumber-1, -way);
            rotation(wheelNumber, way);
        }
    }

    private static void actionRight(int wheelNumber, int way) {
        if (wheelNumber >= 3)
            return;

        if (wheel[wheelNumber+1][6] != wheel[wheelNumber][2]) {
            actionRight(wheelNumber+1, -way);
            rotation(wheelNumber, way);
        }
    }

    private static void rotation(int wheelNumber, int way) {

        //시계 방향
        if (way == 1) {
            int temp = wheel[wheelNumber][7];
            for (int i=7; i>0; --i) {
                wheel[wheelNumber][i] = wheel[wheelNumber][i-1];
            }
            wheel[wheelNumber][0] = temp;
        }

        //반시계 방향
        else {
            int temp = wheel[wheelNumber][0];
            for (int i=0; i<7; ++i) {
                wheel[wheelNumber][i] = wheel[wheelNumber][i+1];
            }
            wheel[wheelNumber][7] = temp;
        }
    }

    private static void printWheel() {
        int sum = 0;

        for (int i=0; i<4; ++i)
            sum += wheel[i][0] * calculate[i];

        System.out.println(sum);
    }

}
