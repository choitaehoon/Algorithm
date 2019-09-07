package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 동전_2 {

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
        int value = 0;
        int count = 0;

        for (int i=array.length-1; i>=0; --i){

            //현재위치한 돈 < 한계 돈 && 가지고 있는 돈 < 한계 돈
            while (array[i] <= k && value + array[i] <= k){
                value += array[i];
                ++count;
            }

        }

        return count;
    }


}
