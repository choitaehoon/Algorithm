package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 로또1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber;

        do {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            givenNumber = Integer.parseInt(token.nextToken());
            int[] lotto = new int[givenNumber];

            for (int i = 0; i < givenNumber; ++i)
                lotto[i] = Integer.parseInt(token.nextToken());

            Arrays.sort(lotto);
            lottoSixCheck(0, givenNumber, 0,lotto, "");
            System.out.println();

        } while (givenNumber != 0);

    }

    private static void lottoSixCheck(int index, int end, int count ,int[] lotto, String word) {
        if (count == 6) {
            System.out.println(word);
            return;
        }

        if (index == end)
            return;

        lottoSixCheck(index + 1, end, count + 1, lotto, word+lotto[index]+" ");
        lottoSixCheck(index + 1, end, count, lotto, word);
    }

}
