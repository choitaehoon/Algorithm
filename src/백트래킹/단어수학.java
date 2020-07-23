package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어수학 {

    static int[] wordSum = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < givenNumber; ++i) {
            String word = buffer.readLine();
            int wordLength = word.length() - 1;

            for (int k = 0; k < word.length(); ++k) {
                wordSum[word.charAt(k) - 'A'] += (int)Math.pow(10, wordLength--);
            }

        }

        Arrays.sort(wordSum);
        int minusMultiple = 9;
        int sum = 0;

        for (int i = 25; i >= 0; --i) {
            if (wordSum[i] != 0) {
                sum += wordSum[i] * minusMultiple --;
            }
        }

        System.out.println(sum);
    }



}
