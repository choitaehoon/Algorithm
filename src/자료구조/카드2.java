package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; ++i) {
            queue.offer(i);
        }

        while (queue.size() >= 2) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.peek());
    }

}
