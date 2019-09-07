package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 동전_3 {

    static int n;
    static int k;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());
        array = new int[n];

        for (int i=0; i<n; ++i)
            array[i] = Integer.parseInt(buffer.readLine());

        System.out.println(findNumberMinimum());
    }

    private static int findNumberMinimum() {
        int value = 0; //동전 값 계산
        int count = 0; //동전 갯수 셈

        for (int i=array.length-1; i>=0; --i){

            //k보다 숫자가 크면 안되니까
            if (array[i] > k)
                continue;

            count += k / array[i];
            k %= array[i];
        }

        return count;
    }

}
