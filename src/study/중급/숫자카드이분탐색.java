package study.중급;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 숫자카드이분탐색 {

    static int[] array;
    static int[] compare;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int givenNumber = Integer.parseInt(buffer.readLine());
        array = new int[givenNumber];
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        for (int i=0; i<givenNumber; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        int compareNumber = Integer.parseInt(buffer.readLine());
        compare = new int[compareNumber];
        StringTokenizer token2 = new StringTokenizer(buffer.readLine());

        for (int i=0; i<compareNumber; ++i)
            compare[i] = Integer.parseInt(token2.nextToken());

        Arrays.parallelSort(array);

        for (int i=0; i<compareNumber; ++i)
            writer.write(recursive(0,array.length-1, compare[i])+" ");
        writer.close();
    }

    static int recursive(int start, int end, int givenNumber) {
        if (start > end) return 0;

        else {
            int middle = (start+end)/2;
            if (array[middle] == givenNumber)
                return 1;
            else if (array[middle] < givenNumber)
                return recursive(middle+1, end, givenNumber);
            else
                return recursive(start,middle-1, givenNumber);
        }

    }
}
