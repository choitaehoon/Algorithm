package 미해결문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 점프 {

    static int givenNumber;
    static int[][] array;
    static long count;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        array = new int[givenNumber][givenNumber];
        check = new boolean[givenNumber][givenNumber];

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
            for (int j=0; j<givenNumber; ++j)
                array[i][j] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i=0; i<givenNumber; ++i) {
            for (int j=0; j<givenNumber; ++j)
                if(check[i][j]) {
                    if (j+array[i][j] < givenNumber)
                        check[i][j+array[i][j]] = true;
                    if (i+array[i][j] < givenNumber)
                        check[i+array[i][j]][j] = true;
                }
        }

    }


}
