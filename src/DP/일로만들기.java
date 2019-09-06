package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기 {

    private static int value = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        recursive(givenNumber, 0);

        System.out.println(value);
    }

    //시간 초과
    private static void recursive(int number, int count) {
        if (number <= 0 ) return;
        if (number == 1) {
            if (value > count)
                value = count;
        }
        if (number % 3 == 0)
            recursive(number/3, count+1);
        if (number %2 == 0)
            recursive(number/2, count+1);

    }

}