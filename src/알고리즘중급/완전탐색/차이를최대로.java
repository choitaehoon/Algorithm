package 알고리즘중급.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 차이를최대로 {

    static int[] array;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        array = new int[givenNumber];

        StringTokenizer token = new StringTokenizer(buffer.readLine());
        for (int i=0; i<givenNumber; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        Arrays.parallelSort(array);

        while (nextPermutation()) {
            int sum = 0;
            for (int i=1; i<givenNumber; ++i)
                sum += Math.abs(array[i-1]-array[i]);
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

    static boolean nextPermutation() {
        int i = array.length-1;
        while (0 < i) {
            if (array[i-1] < array[i]) break;
            --i;
        }

        // i가 0이면 돌게 없으므로
        if (i == 0)
            return false;

        int j = array.length -1;
        while (0 < j) {
            if (array[i-1] < array[j]) break;
            --j;
        }

        swap(i-1,j);

        j = array.length-1;
        while (i < j) {
            swap(i,j);
            ++i; --j;
        }
        return true;
    }

    static void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
