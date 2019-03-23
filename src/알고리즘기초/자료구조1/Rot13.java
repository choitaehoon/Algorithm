package 알고리즘기초.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rot13 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String temp = buffer.readLine();

        char[] smallLetter = new char[26];
        char[] upperLetter = new char[26];

        for (int i=0; i<26; ++i) {
            smallLetter[i] = (char)(97+i);
            upperLetter[i] = (char)(65+i);
        }

        for (int i=0; i<temp.length(); ++i) {

            //공백이면
            if (temp.charAt(i) == 32) {
                System.out.print(" ");
                continue;
            }

            //소문자 이면
            if (96 < temp.charAt(i)) {
                System.out.print(smallLetter[ (((int)temp.charAt(i)- 97) +13) % 26 ]);
                continue;
            }

            //대문자 이면
            if (64 < temp.charAt(i) && temp.charAt(i) < 91) {
                System.out.print(upperLetter[ (((int)temp.charAt(i)- 65) +13) % 26 ]);
                continue;
            }

            System.out.print(temp.charAt(i));
        }

    }
}
