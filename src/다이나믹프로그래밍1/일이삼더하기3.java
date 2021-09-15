package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼더하기3 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < n; ++i) {
            int k = Integer.parseInt(buffer.readLine());
            long[] array = new long[1_000_010];
            array[1] =1; array[2] = 2; array[3] = 4; array[4] = 7;

            for (int m = 5; m <= k; ++m) {
                array[m] = (array[m - 1] + array[m - 2] + array[m - 3]) % 1_000_000_009;
            }

            System.out.println(array[k]);
        }

    }

}
