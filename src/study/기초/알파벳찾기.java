package study.기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알파벳찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String alphabet = buffer.readLine();
        int[] array = new int[26];
        int alphabetLength = alphabet.length();

        Arrays.fill(array,-1);

        for (int i=0; i<alphabetLength; ++i) {
            if (array[alphabet.charAt(i) - 'a'] >= 0)
                continue;
            array[alphabet.charAt(i) - 'a'] = i;
        }

        StringBuilder builder = new StringBuilder();
        for (int data : array)
            builder.append(data).append(" ");

        System.out.println(builder);
    }
}
