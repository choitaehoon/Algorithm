package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 암호만들기1 {

    static int L;
    static int C;
    static String[] code;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        StringTokenizer alphabet = new StringTokenizer(buffer.readLine());

        L = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        code = new String[C];

        for (int i = 0; i < C; ++i)
            code[i] = alphabet.nextToken();

        Arrays.sort(code);
        codeCheck(0, C, 0, 0, 0, "");
    }

    private static void codeCheck(int index, int end, int count, int vowel, int consonant, String word) {

        if (count == L) {
            if (vowel >= 1 && consonant >= 2){
                System.out.println(word);
            }
            return;
        }

        if (index >= end)
            return;

        if (hasVowel(code[index])) {
            codeCheck(index + 1, end, count + 1, vowel + 1, consonant, word+code[index]);
        } else {
            codeCheck(index + 1, end, count + 1, vowel, consonant + 1, word+code[index]);
        }
        codeCheck(index + 1, end, count, vowel, consonant, word);

    }

    private static boolean hasVowel(String word) {
        return word.equals("a") || word.equals("e") || word.equals("i") || word.equals("o") || word.equals("u");
    }
}
