package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카드역배치 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int [] number = new int[20];

        for (int i=0; i<20; ++i)
            number[i] = i+1;

        for (int i=0; i<10; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());

            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            int[] copy = new int[(y-x)+1];
            int index = 0;

            for (int k=x-1; k<y; ++k)
                copy[index++] = number[k];

            for (int k=x-1; k<y; ++k)
                number[k] = copy[--index];

        }

        for (int i=0; i<20; ++i)
            System.out.print(number[i]+" ");
    }
}
