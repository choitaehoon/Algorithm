package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알파벳찾기 {

    static String givenAlphabet;
    static int[] array = new int[26];

    public static void main(String[] args) throws IOException {
        inputAlphabet();
        actionAlphabet();
        printAlphabet();
    }

    private static void inputAlphabet() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenAlphabet = buffer.readLine();

        Arrays.fill(array, -1);
    }

    private static void actionAlphabet() {
        for (int i=0; i<givenAlphabet.length(); ++i) {
            yesAlphabet(i);
        }
    }

    private static void yesAlphabet(int i) {
        if (array[(int)givenAlphabet.charAt(i) - 97] >= 0)
            return;

        array[(int)givenAlphabet.charAt(i) - 97] = i;
    }

    private static void printAlphabet() {
        for (int i=0; i<26; ++i) {
            System.out.print(array[i]+" ");
        }
    }

}
