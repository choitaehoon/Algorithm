package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 행복2 {

    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        array = new int[givenNumber];

        StringTokenizer token = new StringTokenizer(buffer.readLine());
        for (int i=0; i<givenNumber; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        Arrays.parallelSort(array);
        System.out.println(array[givenNumber-1] - array[0]);
    }

}
