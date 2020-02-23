package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한국이그리울땐서버에접속하지 {

    public static void main(String[] args) throws IOException {
        inputWord();
    }

    private static void inputWord() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        int givenNumber = Integer.parseInt(buffer.readLine());
        String[] pattern = buffer.readLine().split("[*]");
        String resultPattern = pattern[0]+"[a-z]*"+pattern[1];

        for (int i=0; i<givenNumber; ++i) {
            String givenWord = buffer.readLine();
            givenWord = givenWord.replaceAll(resultPattern, "");

            if (givenWord.isEmpty())
                System.out.println("DA");
            else
                System.out.println("NE");
        }

    }


}
