package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼더하기 {

    static int standard;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        array = new int[12];

        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 4;
        array[4] = 7;

        for (int i = 0; i < givenNumber; ++i) {
            standard = Integer.parseInt(buffer.readLine());
            System.out.println(recursive(standard));
        }
    }

    static int recursive(int number) {
        if (number < 0) return 0;

        if (array[number] > 0) return array[number];

        else
            return array[number] = recursive(number - 3) + recursive(number - 2) +
                    recursive(number - 1);
    }
}
