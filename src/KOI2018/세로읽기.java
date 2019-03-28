package KOI2018;

import java.util.Scanner;

public class 세로읽기 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] letterArray = new String[5][15];
        int maxLength = 0;

        for (int i=0; i<5; ++i) {
            String[] givenLetter = input.nextLine().split("");
            int letterCount = givenLetter.length;
            maxLength = Math.max(maxLength, letterCount);
            for (int j=0; j<letterCount; ++j)
                letterArray[i][j] = givenLetter[j];
        }

        StringBuilder builder = new StringBuilder();

        for (int i=0; i<maxLength; ++i) {
            for (int j=0; j<5; ++j)
                if (letterArray[j][i] != null)
                    builder.append(letterArray[j][i]);
        }

        System.out.println(builder);
    }
}
