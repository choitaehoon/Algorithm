package study.중급;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 숫자카드2반복문 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int givenNumber = Integer.parseInt(buffer.readLine());
        int [] array = new int[20000002];
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            int number = Integer.parseInt(token.nextToken());
            if (number < 0) {
                number *= -1;
                number +=10000000;
            }
            array[number]++;
        }

        int compareNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer token2 = new StringTokenizer(buffer.readLine());

        for (int i=0; i<compareNumber; ++i) {
            int number = Integer.parseInt(token2.nextToken());
            if (number < 0){
                number *= -1;
                number +=10000000;
            }
            writer.write(array[number]+" ");
        }

        writer.close();
    }
}
