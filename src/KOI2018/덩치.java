package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치 {

    public static int [][] physical;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        physical = new int[givenNumber][2];
        int[] rank = new int[givenNumber];

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            physical[i][0] = x;
            physical[i][1] = y;
            rank[i] = 1;
        }


        for (int i=0; i<givenNumber; ++i) {
            for (int j=0; j<givenNumber; ++j) {
                if (physical[i][0] > physical[j][0] && physical[i][1] > physical[j][1])
                    rank[j]++;
            }
        }

        for (int i=0; i<givenNumber; ++i)
            System.out.println(rank[i]);
    }
}
