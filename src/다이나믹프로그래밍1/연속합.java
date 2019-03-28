package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합 {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int[] sequenceArray = new int[givenNumber];
        int[] maxSequence = new int[givenNumber];

        for (int i=0; i<givenNumber; ++i)
            sequenceArray[i] = Integer.parseInt(token.nextToken());


        maxSequence[0] = sequenceArray[0];
        int max = sequenceArray[0];

        for (int i=1; i<givenNumber; ++i) {
            maxSequence[i] = Math.max(sequenceArray[i], maxSequence[i-1] + sequenceArray[i]);
            max = Math.max(max,maxSequence[i]);
        }

        System.out.println(max);
    }
}
