package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 주식 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < test; ++i) {
            int count = Integer.parseInt(buffer.readLine());
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int[] array = new int[count];

            for (int k = 0; k < count; ++k)
                array[k] = Integer.parseInt(token.nextToken());

            solutionGo(array, count);
        }
    }

    private static void solutionGo(int[] array, int count) {
        long sum = 0;
        int max = 0;

        for (int i = count - 1; i >= 0; --i) {
            if (max < array[i])
                max = array[i];
            else
                sum += max - array[i];
        }

        System.out.println(sum);
    }

}
