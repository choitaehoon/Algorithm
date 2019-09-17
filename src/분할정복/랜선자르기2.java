package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 랜선자르기2 {

    static int k;
    static int n;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        k = Integer.parseInt(token.nextToken());
        n = Integer.parseInt(token.nextToken());
        array = new int[k];

        for (int i=0; i<k; ++i)
            array[i] = Integer.parseInt(buffer.readLine());

        //이분 탐색에서 정렬 한 후 찾아야 하기 때문
        Arrays.sort(array);
        System.out.println(calculate());
    }

    //int를 벗어난 값이 존재 할 수 있으므로 long
    private static long calculate() {
        long start = 1;
        long end = array[k-1];
        long max = 0;

        while (start <= end){
            long middle = (start+end)/2;
            int count = 0;

            for (int i=0; i<k; ++i)
                count += array[i] / middle;

            if (count < n)
                end = middle -1;
            else {
                start = middle +1;
                max = middle;
            }

        }

        return max;
    }

}
