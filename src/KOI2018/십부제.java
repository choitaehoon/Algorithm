package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 십부제 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String givenNumber = buffer.readLine();
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int matchSum =0;

        String[] carArray = new String[5];

        for (int i=0; i<5; ++i)
            carArray[i] = token.nextToken();

        for (int i=0; i<5; ++i)
            if (givenNumber.charAt(0) == carArray[i].charAt(carArray[i].length()-1))
                matchSum++;


        System.out.println(matchSum);
    }
}
