package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 저울 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int[] array = new int[n + 1];
        int[] sum = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(array);

        for (int i = 1; i <=n; ++i)
            sum[i] += sum[i - 1] + array[i];

        boolean check = false;
        int index = 0;
        for (int i = 1; i <= n; ++i) {
            if (array[i] > sum[i - 1] + 1) {
                check = true;
                index = i;
                break;
            }
        }

        System.out.println(check ? sum[index - 1] + 1 : sum[n] + 1);
    }

}
