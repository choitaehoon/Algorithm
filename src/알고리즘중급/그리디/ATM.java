package 알고리즘중급.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        int[] array = new int[givenNumber];

        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());

        for (int i=0; i<givenNumber; ++i)
            array[i] = Integer.parseInt(tokenizer.nextToken());

        Arrays.sort(array);

        int result=0;
        int sum = 0;
        for (int i=0; i<givenNumber; ++i)
            result += sum += array[i];

        System.out.println(result);
    }
}
