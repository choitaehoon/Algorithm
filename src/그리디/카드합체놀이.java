package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드합체놀이 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t1 = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(t1.nextToken());
        int m = Integer.parseInt(t1.nextToken());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        Queue<Long> queue = new PriorityQueue<>();

        for (int i = 0; i < n; ++i)
            queue.offer(Long.parseLong(token.nextToken()));

        for (int i = 0; i < m; ++i) {
            long a = queue.poll();
            long b = queue.poll();

            long sum = a + b;
            queue.offer(sum);
            queue.offer(sum);
        }

        int len = queue.size();
        long sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += queue.poll();
        }

        System.out.println(sum);
    }


}
