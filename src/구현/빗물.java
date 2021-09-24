package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        StringTokenizer token2 = new StringTokenizer(buffer.readLine());
        int no = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());
        int[] array = new int[n];

        for (int i = 0; i < n; ++i)
            array[i] = Integer.parseInt(token2.nextToken());

        int sum = 0;
        for (int i = 1; i < n - 1; ++i) {
            int leftValue = 0;
            int rightValue = 0;

            for (int left = i - 1; left >= 0; --left) {
                leftValue = Math.max(leftValue, array[left]);
            }

            for (int right = i + 1; right < n; ++right) {
                rightValue = Math.max(rightValue, array[right]);
            }

            int min = Math.min(leftValue, rightValue);
            if (min <= array[i])
                continue;

            sum += min - array[i];
        }

        System.out.println(sum);
    }

}
