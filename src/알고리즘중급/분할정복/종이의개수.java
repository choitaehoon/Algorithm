package 알고리즘중급.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 종이의개수 {

    static int givenNumber;
    static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        array = new int[givenNumber][givenNumber];

        for (int i=0; i<givenNumber; ++i){
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int j=0; j<givenNumber; ++j)
                array[i][j] = Integer.parseInt(token.nextToken());
        }

        
    }
}
