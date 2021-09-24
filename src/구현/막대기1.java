package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 막대기1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(buffer.readLine());
        }

        int value = array[n - 1];
        int max = value;
        int count = 1;
        for (int i = n - 2; i >= 0; --i) {
            if (max < array[i]) {
                ++count;
                max = array[i];
            }
        }

        System.out.println(count);
    }

}
