package 알고리즘중급.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class 수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        int[] array = new int[givenNumber];

        for (int i=0; i < givenNumber; ++i)
            array[i] =Integer.parseInt(buffer.readLine());

        Arrays.sort(array);

        int start = 0;
        int end = array.length-1;
        int sum = 0;

        for (; start < end; start+=2) {
            if (array[start] < 1 && array[start+1] < 1)
                sum += array[start] * array[start+1];
            else
                break;
        }

        for (; end > start;  end -= 2) {
            if (array[end] > 1 && array[end-1] > 1)
                sum += array[end] * array[end-1];
            else
                break;
        }

        for (; start<=end; ++start)
            sum += array[start];

        System.out.println(sum);
    }
}
