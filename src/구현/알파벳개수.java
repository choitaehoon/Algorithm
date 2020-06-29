package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String word = buffer.readLine();

        int[] alphabet = new int[26];

        for (int i = 0; i < word.length(); ++i)
            alphabet[word.charAt(i) - 'a']++;

        for (int i = 0; i < 26; ++i)
            System.out.println(alphabet[i]);
    }

}
