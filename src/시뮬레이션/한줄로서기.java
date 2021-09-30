package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한줄로서기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int[] result = new int[n];
        for (int i = 1; i <= n; ++i) {
           int nowNum = Integer.parseInt(token.nextToken());
           for (int k = 0; k <n; ++k)
               if (result[k] == 0 && nowNum == 0) {
                   result[k] = i;
                   break;
               }
               else if (result[k] == 0)
                   nowNum--;
        }

        for (int i = 0; i < n; ++i)
            System.out.print(result[i] + " ");
    }

}
