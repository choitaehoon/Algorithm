package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 막대기 {

    static int givenNumber;

    public static void main(String[] args) throws IOException {
        inputGivenNumber();
        calculateGivenNumber();
    }

    private static void inputGivenNumber() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        givenNumber = Integer.parseInt(buffer.readLine());
    }

    private static void calculateGivenNumber() {
        int length = 0;

        while (givenNumber != 0) {
            if (givenNumber % 2 == 1)
                length++;
            givenNumber /= 2;
        }

        System.out.println(length);
    }
}
