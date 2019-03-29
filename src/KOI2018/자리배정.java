package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 자리배정 {

    static int[][] circle;

    //상 우 하 좌
    static int [] xArray = {-1,0,1,0};
    static int [] yArray = {0,1,0,-1};
    static int arrayIndex;
    static int seatArrangement = 1;
    static boolean [][] checkSeat;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int vertical = Integer.parseInt(token.nextToken());
        int width = Integer.parseInt(token.nextToken());

        int givenNumber = Integer.parseInt(buffer.readLine());

        circle = new int[width][vertical];
        checkSeat = new boolean[width][vertical];

        int x = width-1;
        int y = 0;

        //관객을 배치 할 수 없다
        if (vertical * width < givenNumber) {
            System.out.println(0);
            return;
        }

        while (seatArrangement != givenNumber) {

            if (x+xArray[arrayIndex] < 0 || x+xArray[arrayIndex] >= width || y+yArray[arrayIndex] < 0 || y+yArray[arrayIndex] >= vertical
                    || checkSeat[x+xArray[arrayIndex]][y+yArray[arrayIndex]]) {

                arrayIndex = (arrayIndex+1)%4;
                continue;
            }

            circle[x][y] = seatArrangement++;
            checkSeat[x][y] = true;

            x += xArray[arrayIndex];
            y += yArray[arrayIndex];
        }

        System.out.println((y+1) + " "+ (width-x));
    }
}
