package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상수 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        StringBuilder builder1 = new StringBuilder(token.nextToken());
        StringBuilder builder2 = new StringBuilder(token.nextToken());

        int a = Integer.parseInt(builder1.reverse().toString());
        int b = Integer.parseInt(builder2.reverse().toString());

        System.out.println(Math.max(a, b));
    }

}
