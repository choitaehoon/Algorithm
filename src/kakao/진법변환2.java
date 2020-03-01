package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진법변환2 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        int givenNumber = Integer.parseInt(token.nextToken());
        int notation = Integer.parseInt(token.nextToken());
        StringBuilder builder = new StringBuilder();

        while (givenNumber != 0) {
            int temp = givenNumber % notation;
            
            if (temp < 10)
                builder.append((char)(temp + 48));
            else
                builder.append((char)(temp + 55));

            givenNumber /= notation;
        }

        System.out.println(builder.reverse().toString());
    }

}
