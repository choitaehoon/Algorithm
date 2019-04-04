package 규칙찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        int multiple;
        int index = 2;
        int increasingNumber = 7;
        int sum = 2;

        if (givenNumber == 1) {
            System.out.println(1);
            return;
        }

        while (increasingNumber < givenNumber) {
            multiple = 6*index++;
            increasingNumber += multiple;
            ++sum;
        }

        System.out.println(sum);
    }
}
