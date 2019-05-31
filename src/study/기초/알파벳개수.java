package study.기초;

import java.io.*;

public class 알파벳개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String alphabet = buffer.readLine();
        int[] array = new int[26];
        int alphabetLength = alphabet.length();

        for (int i=0; i<alphabetLength; ++i)
            array[alphabet.charAt(i) - 'a']++;

        for (int i=0; i<26; ++i)
            writer.write(array[i]+" ");

        writer.close();
    }
}
