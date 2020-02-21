package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 유학금지 {

    static String givenWord;

    public static void main(String[] args) throws IOException {
        inputGivenWord();
        actionGo();
    }

    private static void inputGivenWord() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenWord = buffer.readLine();
    }

    private static void actionGo() {
        givenWord = givenWord.replaceAll("[CAMBRIDGE]", "");
        System.out.println(givenWord);
    }

}
