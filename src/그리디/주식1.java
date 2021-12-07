package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주식1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < givenNumber; ++i) {
            int num = Integer.parseInt(buffer.readLine());
            int[] array = new int[num];

            StringTokenizer token = new StringTokenizer(buffer.readLine());

            for (int k = 0; k < num; ++k)
                array[k] = Integer.parseInt(token.nextToken());

            maxBenefit(array, num);
        }

    }

    private static void maxBenefit(int[] array, int num) {
        long max = 0;
        long sum = 0;
        for (int i = num - 1; i >= 0; --i) {
            if (max < array[i]) {
                max = array[i];
            } else {
                sum += max - array[i];
            }
        }

        System.out.println(sum);
    }

}
