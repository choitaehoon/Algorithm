package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공 {

    static int givenNumber;
    static int[] array = {0, 1, 2 ,3};

    public static void main(String[] args) throws IOException {
        inputGivenNumber();
        printBall();
    }

    private static void inputGivenNumber() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        actionChange(buffer);
    }

    private static void actionChange(BufferedReader buffer) throws IOException {
        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token =
                    new StringTokenizer(buffer.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            int xPosition = 0;
            int yPosition = 0;

            for (int j=1; j<4; ++j) {
                if (array[j] == x) {
                    xPosition = j;
                } else if (array[j] == y) {
                    yPosition = j;
                }
            }

            changeCup(xPosition, yPosition);
        }
    }

    private static void changeCup(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    private static void printBall() {
        System.out.println(array[1]);
    }
}
