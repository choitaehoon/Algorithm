package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박수 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i = 3; i <= givenNumber; ++i) {
            String nowNumber = String.valueOf(i);
            checkNumber(nowNumber);
        }

        System.out.println(count);
    }

    private static void checkNumber(String nowNumber) {
        int nowNumberLen = nowNumber.length();
        for(int i = 0; i < nowNumberLen; ++i) {
            if (nowNumber.charAt(i) == '3' || nowNumber.charAt(i) == '6' || nowNumber.charAt(i) == '9')
                ++count;
        }
    }
}
