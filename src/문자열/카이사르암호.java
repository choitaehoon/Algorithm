package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 카이사르암호 {

    static String givenWord;
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        inputGivenWord();
        actionChange();
        printGo();
    }

    private static void inputGivenWord() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenWord = buffer.readLine();
    }

    private static void actionChange() {

        for (int i=0; i<givenWord.length(); ++i) {
            int len = givenWord.charAt(i) - 3;
            if (len < 65)
                builder.append((char)(len + 26));
            else
                builder.append((char)(len));
        }

    }

    private static void printGo() {
        System.out.println(builder);
    }
}
