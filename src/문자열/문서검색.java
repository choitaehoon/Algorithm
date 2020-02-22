package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문서검색 {

    public static void main(String[] args) throws IOException {
        inputWord();
    }

    private static void inputWord() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        String document = buffer.readLine();
        String compareWord = buffer.readLine();

        actionWord(document, compareWord);
    }

    private static void actionWord(String document, String compareWord) {
        int sum = 0;

        for (int i=0; i<document.length(); ) {
            if (i + compareWord.length() > document.length())
                break;

            else if (document.substring(i, i+compareWord.length()).equals(compareWord)) {
                ++sum;
                i += compareWord.length();
            } else
                ++i;

        }

        System.out.println(sum);

    }

}
