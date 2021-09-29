package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 전깃줄 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        List<Electronic> list = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            list.add(new Electronic(start, end));
        }
        list.sort(Comparator.comparingInt(a -> a.start));
        int[] array = new int[n];

        for (int i = 0; i < list.size(); ++i) {
            array[i] = list.get(i).end;
        }

        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;

            for (int k = 0; k < i; ++k) {
                if (array[k] < array[i])
                    dp[i] = Math.max(dp[i], dp[k] + 1);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);
    }

}

class Electronic{

    int start;
    int end;

    public Electronic(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
