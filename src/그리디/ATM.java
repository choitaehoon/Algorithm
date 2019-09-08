package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {

    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        array = new int[givenNumber];

        for (int i=0; i<givenNumber; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        System.out.println(calculate());
    }

    private static int calculate() {
        int value = 0;
        int sum = 0;

        Arrays.sort(array);
        for (int i=0; i<array.length; ++i)
            sum += value += array[i];

        return sum;
    }


}
