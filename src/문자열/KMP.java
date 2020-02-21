package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMP {

    static String givenWord;
    static String result = "";

    public static void main(String[] args) throws IOException {
        inputGivenWord();
        actionWord();
        printGo();
    }

    private static void inputGivenWord() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenWord = buffer.readLine();
    }

    private static void actionWord() {
        String[] temp = givenWord.split("-");
        for (String keword : temp)
            result += keword.charAt(0);
    }

    private static void printGo() {
        System.out.println(result);
    }

}
