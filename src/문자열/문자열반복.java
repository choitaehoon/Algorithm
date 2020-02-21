package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열반복 {

    public static void main(String[] args) throws IOException {
        inputGivenNumberAndWord();
    }

    private static void inputGivenNumberAndWord() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token =
                    new StringTokenizer(buffer.readLine());
            int num = Integer.parseInt(token.nextToken());
            String temp = token.nextToken();

            actionWord(num, temp);
        }
    }

    private static void actionWord(int num, String temp) {
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<temp.length(); ++i) {
            for (int j=0; j<num; ++j)
                builder.append(temp.charAt(i));
        }

        System.out.println(builder);
    }

}
