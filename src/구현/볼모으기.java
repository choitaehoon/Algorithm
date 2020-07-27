package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class 볼모으기 {

    static int red;
    static int blue;
    static int result;
    static int count;
    static int givenNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        String ball = buffer.readLine();

        red = 0;
        blue = 0;
        result = 0;
        count = 0;

        for (int i = 0; i < givenNumber; ++i) {
            if (ball.charAt(i) == 'R')
                ++red;
            else
                ++blue;
        }
        result = Math.min(red, blue);

        for (int i = 0; i < givenNumber; ++i) {
            if (ball.charAt(i) != ball.charAt(0))
                break;
            ++count;
        }

        checkRedOrBlue("left", ball);
        count = 0;

        for (int i = givenNumber - 1; i >= 0; --i) {
            if (ball.charAt(i) != ball.charAt(givenNumber - 1))
                break;
            ++count;
        }

        checkRedOrBlue("right", ball);
        System.out.println(result);
    }

    private static void checkRedOrBlue(String direction, String ball) {
        if (direction.equals("left")) {
            if (ball.charAt(0) == 'R') {
                result = Math.min(result, red - count);
            } else {
                result = Math.min(result, blue - count);
            }
        }

        else if (direction.equals("right")) {
            if (ball.charAt(givenNumber - 1) == 'R')
                result = Math.min(result, red - count);
            else
                result = Math.min(result, blue - count);
        }
    }

}