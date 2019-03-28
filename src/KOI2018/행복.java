package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행복 {

    public static int maxScore;
    public static int minScore = Integer.MAX_VALUE;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int[] studentScore = new int[givenNumber];

        for (int i=0; i<studentScore.length; ++i)
            studentScore[i] = Integer.parseInt(token.nextToken());

        for (int i=0; i<givenNumber; ++i) {
            maxScore = Math.max(maxScore, studentScore[i]);
            minScore = Math.min(minScore,studentScore[i]);
        }

        System.out.println(maxScore - minScore);
    }
}
