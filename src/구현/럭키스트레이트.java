package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 럭키스트레이트 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String number = buffer.readLine();
        int half = number.length() / 2;

        int compare1 = 0;
        for (int i = 0; i < half; ++i)
            compare1 += Integer.parseInt(String.valueOf(number.charAt(i)));

        int compare2 = 0;
        for (int i = half; i < number.length(); ++i)
            compare2 += Integer.parseInt(String.valueOf(number.charAt(i)));

        System.out.println(compare1 == compare2 ? "LUCKY" : "READY");
    }

}
