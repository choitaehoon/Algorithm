package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳거리 {

    static int givenNumber;

    public static void main(String[] args) throws IOException {
        inputGivenNumber();
    }

    private static void inputGivenNumber() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        givenNumber = Integer.parseInt(buffer.readLine());
        actionWord(buffer);
    }

    private static void actionWord(BufferedReader buffer) throws IOException {

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token =
                    new StringTokenizer(buffer.readLine());
            String A = token.nextToken();
            String B = token.nextToken();

            actionWord(A, B);
        }

    }

    private static void actionWord(String a, String b) {
        StringBuilder builder = new StringBuilder();
        builder.append("Distances: ");

        for (int i=0; i<a.length(); ++i) {
            if (a.charAt(i) <= b.charAt(i))
                builder.append(b.charAt(i) - a.charAt(i)).append(" ");
            else
                builder.append(b.charAt(i) + 26 - a.charAt(i)).append(" ");
        }

        System.out.println(builder);
    }

}
