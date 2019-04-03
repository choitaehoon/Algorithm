package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 간지 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        System.out.printf("%c%d",(givenNumber+8)%12+'A', (givenNumber+6)%10);
    }
}
