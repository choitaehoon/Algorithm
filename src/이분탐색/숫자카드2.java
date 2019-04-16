package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2 {

    static int[] givenArray;
    static int[] cardArray;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer givenToken = new StringTokenizer(buffer.readLine());

        givenArray = new int[givenNumber];
        for (int i=0; i<givenNumber; ++i)
            givenArray[i] = Integer.parseInt(givenToken.nextToken());
        Arrays.parallelSort(givenArray);


        int givenCardNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer givenCard = new StringTokenizer(buffer.readLine());
        cardArray = new int[givenCardNumber];

        for (int i=0; i<givenCardNumber; ++i)
            cardArray[i] = Integer.parseInt(givenCard.nextToken());

        for (int i=0; i<givenCardNumber; ++i)
            System.out.print(binarySearch(0, givenArray.length-1, cardArray[i])+" ");
    }

    @SuppressWarnings("Duplicates")
    public static int binarySearch(int start, int end, int givenNumber) {
        if (start > end) return 0;

        else {
            int middle = (start+end)/2;

            if (givenArray[middle] == givenNumber)
                return binarySearch(middle+1, end, givenNumber) + binarySearch(start, middle-1, givenNumber) +1;
            else if (givenArray[middle] < givenNumber)
                return binarySearch(middle+1, end, givenNumber);
            else
                return binarySearch(start,middle-1,givenNumber);
        }

    }
}
