package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 다음순열 {

    static int[] array ;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        array = new int[givenNumber];
        StringTokenizer token = new StringTokenizer(buffer.readLine());


        for (int i=0; i<givenNumber; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        if (nextPermutation()) {
            for (int i=0; i<givenNumber; ++i)
                System.out.print(array[i]+" ");
            return;

        }
        System.out.println(-1);
    }

    private static boolean nextPermutation() {
        int i= array.length-1;

        while (0 < i && array[i] < array[i-1])
            --i;

        if (i <= 0) return false;

        int j = array.length-1;

        while (0 < j && array[i-1] > array[j])
            --j;

        array[i-1] ^= array[j];
        array[j] ^= array[i-1];
        array[i-1] ^= array[j];

        j= array.length-1;
        while (i<j) {
            array[i] ^= array[j];
            array[j] ^= array[i];
            array[i] ^= array[j];
            i++;
            j--;
        }
        return true;
    }


}
