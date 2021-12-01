package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드합체놀이1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        PriorityQueue<Long> queue = new PriorityQueue<>();
        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        for (int i = 0; i < n; ++i)
            queue.offer(Long.parseLong(tokenizer.nextToken()));

        for (int i = 0; i < m; ++i) {
            long sum = queue.poll() + queue.poll();

            queue.add(sum);
            queue.add(sum);
        }

        long result = 0;
        for (Long value : queue)
            result += value;

        System.out.println(result);
    }

}
