package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class five와six의차이 {

    static String givenA;
    static String givenB;
    static int max;
    static int min;

    public static void main(String[] args) throws IOException {
        inputGivenNumber();
        actionMax();
        actionMin();
        printGo();
    }

    private static void inputGivenNumber() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        givenA = token.nextToken();
        givenB = token.nextToken();
    }

    private static void actionMax() {
        givenA = givenA.replace("5", "6");
        givenB = givenB.replace("5", "6");

        max = Integer.parseInt(givenA) + Integer.parseInt(givenB);
    }

    private static void actionMin() {
        givenA = givenA.replace("6", "5");
        givenB = givenB.replace("6", "5");

        min = Integer.parseInt(givenA) + Integer.parseInt(givenB);
    }

    private static void printGo() {
        System.out.println(min+" "+max);
    }
}
