package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@SuppressWarnings("all")
public class 수묶기 {

    static int[] array;

    public static void main(String[] args) throws IOException {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        int givenNumber = Integer.parseInt(buffer.readLine());
//        array = new int[givenNumber];
//
//        for (int i=0; i<givenNumber; ++i)
//            array[i] = Integer.parseInt(buffer.readLine());

        array = new int[]{-7,-6,-5,-4,-3};
        Arrays.sort(array);

        System.out.println(maximum());
    }

    private static int maximum() {
        int value = 0;
        int start = 0;
        int end = array.length-1;

        for (; start < end; start+=2){
            if (array[start] < 1 && array[start+1] < 1)
                value += array[start] * array[start+1];
            else
                break;
        }

        for (; end >start; end -=2){
            if (array[end] > 1 && array[end-1] > 1)
                value += array[end] * array[end-1];
            else
                break;
        }

        for (; start<=end; ++start)
            value += array[start];

        return value;
    }

}