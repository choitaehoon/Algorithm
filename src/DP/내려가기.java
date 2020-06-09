package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 내려가기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = stringToInt(buffer.readLine());

        int[][] maxNumber = new int[givenNumber][3];
        int[][] minNumber = new int[givenNumber][3];
        int[][] array = new int[givenNumber][3];

        for (int width = 0; width < givenNumber; ++width) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int vertical = 0; vertical < 3; ++vertical) {
                array[width][vertical] = stringToInt(token.nextToken());
            }
        }

        for (int[] min : minNumber)
            Arrays.fill(min, Integer.MAX_VALUE);

        for (int width = 0; width < givenNumber; ++width) {
            for (int vertical = 0; vertical < 3; ++vertical) {
                if (width == 0) {
                    maxNumber[width][vertical] = array[width][vertical];
                    minNumber[width][vertical] = array[width][vertical];
                } else {
                    if (vertical == 0) {
                        maxNumber[width][0] = Math.max(maxNumber[width-1][0], maxNumber[width-1][1]) + array[width][0];
                        minNumber[width][0] = Math.min(minNumber[width-1][0], minNumber[width-1][1]) + array[width][0];
                    } else if (vertical == 1) {
                        maxNumber[width][1] = Math.max(maxNumber[width-1][0], Math.max(maxNumber[width-1][1], maxNumber[width-1][2])) + array[width][1];
                        minNumber[width][1] = Math.min(minNumber[width-1][0], Math.min(minNumber[width-1][1], minNumber[width-1][2])) + array[width][1];
                    } else {
                        maxNumber[width][2] = Math.max(maxNumber[width-1][1], maxNumber[width-1][2]) + array[width][2];
                        minNumber[width][2] = Math.min(minNumber[width-1][1], minNumber[width-1][2]) + array[width][2];
                    }
                }
            }
        }

        int maxResult = maxNumber[givenNumber-1][0];
        int minResult = minNumber[givenNumber-1][0];
        for (int vertical = 1; vertical < 3; ++vertical) {
            maxResult = Math.max(maxResult, maxNumber[givenNumber-1][vertical]);
            minResult = Math.min(minResult, minNumber[givenNumber-1][vertical]);
        }

        System.out.println(maxResult+" "+minResult);
    }

    private static int stringToInt(String word) {
        return Integer.parseInt(word);
    }

}
