package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자카드2배열로풀기 {

    static int[] givenArray = new int[20000001];
    static int HALF = 10000000;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer givenToken = new StringTokenizer(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            int number = Integer.parseInt(givenToken.nextToken());
            givenArray[HALF+number]++;
        }

        int givenCardNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer givenCard = new StringTokenizer(buffer.readLine());

        for (int i=0; i<givenCardNumber; ++i) {
            int number = Integer.parseInt(givenCard.nextToken());
            System.out.print(givenArray[HALF+number]+" ");
        }

    }
}
