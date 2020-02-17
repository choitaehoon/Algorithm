package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크로아티아알파벳 {


    public static void main(String[] args) throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String givenAlphabet = buffer.readLine();

        for (int i=0; i<8; ++i)
            givenAlphabet = givenAlphabet.replace(croatia[i], "z");

        System.out.println(givenAlphabet.length());
    }

}
