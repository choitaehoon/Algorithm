package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그룹단어체커1 {

    static int countWord;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < givenNumber; ++i) {
            countWordCheck(buffer.readLine());
        }

        System.out.println(countWord);
    }

    private static void countWordCheck(String word) {
        boolean[] wordIndex = new boolean[26];
        int len = word.length();
        char preWordCharAt = ' ';
        boolean isImPossible = false;

        for (int i = 0; i < len; ++i) {
            char nowWordCharAt = word.charAt(i);
            if (!wordIndex[nowWordCharAt - 'a'] || preWordCharAt == nowWordCharAt) {
                wordIndex[nowWordCharAt - 'a'] = true;
                preWordCharAt = nowWordCharAt;
            } else {
                isImPossible = true;
                break;
            }

        }

        if (!isImPossible)
            ++countWord;

    }

}
