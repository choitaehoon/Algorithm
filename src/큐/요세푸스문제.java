package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; ++i)
            queue.add(i);

        extractionQueue(n, k, queue);
    }

    private static void extractionQueue(int n, int k, Queue<Integer> queue) {
        StringBuilder builder = new StringBuilder();

        builder.append("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; ++i) {
                queue.add(queue.poll());
            }

            if (queue.size() >= 2)
                builder.append(queue.poll()).append(", ");
            else
                builder.append(queue.poll());
        }
        builder.append(">");

        System.out.println(builder);
    }

}
