package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수학숙제 {

    static int givenNumber;
    static List<BigInteger> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        inputGivenNumberAndWord();
        printGo();
    }

    private static void inputGivenNumberAndWord() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i)
            actionNumberExtract(buffer);
    }

    private static void actionNumberExtract(BufferedReader buffer) throws IOException {
        String store = buffer.readLine();
        String temp = "";

        for (int i=0; i<store.length(); ++i) {
            if ('0' <= store.charAt(i) && store.charAt(i) <= '9') {
                temp += String.valueOf(store.charAt(i));
            }
            else {
                if (!temp.equals("")) {
                    list.add(new BigInteger(temp));
                    temp = "";
                }
            }

            if (i == store.length() -1){
                if (!temp.equals("")) {
                    list.add(new BigInteger(temp));
                    temp = "";
                }
            }

        }

    }

    private static void printGo() {
        Collections.sort(list);

        for (BigInteger bigInteger : list)
            System.out.println(bigInteger);
    }

}
