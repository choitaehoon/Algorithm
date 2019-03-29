package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 과자 {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int cracker = Integer.parseInt(token.nextToken());
        int givenNumber = Integer.parseInt(token.nextToken());
        int moneyToReceive = Integer.parseInt(token.nextToken());

        System.out.println((cracker * givenNumber) - moneyToReceive < 0 ? 0 : (cracker * givenNumber) - moneyToReceive );
    }
}
