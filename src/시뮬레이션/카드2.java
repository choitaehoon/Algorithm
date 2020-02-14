package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2 {

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        inputQueue();
        removeCard();
    }

    private static void inputQueue() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=1; i<=givenNumber; ++i)
            queue.offer(i);
    }

    private static void removeCard() {
        while (queue.size() != 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());
    }

}
