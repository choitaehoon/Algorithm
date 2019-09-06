package KOI2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 타일장식물 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        long [] array = new long[givenNumber+1];
        array[0] = 1;
        array[1] = 1;

        for (int i=2; i<=givenNumber; ++i)
            array[i] = array[i-1] + array[i-2];

        System.out.println(array[givenNumber] * 2 + array[givenNumber-1] * 2);
    }

}
