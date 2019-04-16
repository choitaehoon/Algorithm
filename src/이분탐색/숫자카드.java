package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드 {

    static int[] givenArray;
    static int[] compareArray;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer givenToken = new StringTokenizer(buffer.readLine());
        givenArray = new int[givenNumber];

        for (int i=0; i<givenNumber; ++i)
            givenArray[i] = Integer.parseInt(givenToken.nextToken());

        Arrays.parallelSort(givenArray);

        int compareNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer compareToken = new StringTokenizer(buffer.readLine());
        compareArray = new int[compareNumber];

        for (int i=0; i<compareNumber; ++i)
            compareArray[i] = Integer.parseInt(compareToken.nextToken());

        for (int i=0; i<compareNumber; ++i)
            System.out.print(binarySearch(0,givenArray.length-1, compareArray[i])+" ");
    }

    public static int binarySearch (int start, int end ,int givenNumber) {
        if (start > end) return 0;

        else {
            int middle = (start+end)/2;
            if (givenArray[middle] == givenNumber)
                return 1;
            if (givenArray[middle] < givenNumber)
                return binarySearch(middle+1, end, givenNumber);
            else
                return binarySearch(start, middle-1, givenNumber);
        }
    }
}
