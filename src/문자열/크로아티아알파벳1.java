package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크로아티아알파벳1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String word = buffer.readLine();
        String[] compareWord = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (int i = 0; i < compareWord.length; ++i) {
            word = word.replace(compareWord[i], "1");
        }

        System.out.println(word.length());
    }

}
