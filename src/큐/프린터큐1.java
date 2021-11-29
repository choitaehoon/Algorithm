package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 프린터큐1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < givenNumber; ++i) {
            StringTokenizer token1 = new StringTokenizer(buffer.readLine());
            StringTokenizer token2 = new StringTokenizer(buffer.readLine());

            int n = Integer.parseInt(token1.nextToken());
            int m = Integer.parseInt(token1.nextToken());

            List<Integer> store = new ArrayList<>();
            int len = token2.countTokens();
            for (int k = 0; k < len; ++k)
                store.add(Integer.parseInt(token2.nextToken()));

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a1, a2) -> a2 - a1);
            for (int k = 0; k < len; ++k)
                priorityQueue.add(store.get(k));

            Queue<Printer> queue = new LinkedList<>();
            for (int k = 0; k < len; ++k)
                queue.add(new Printer(store.get(k), k));

            searchQueue(queue, priorityQueue, m);
        }

    }

    private static void searchQueue(Queue<Printer> queue, PriorityQueue<Integer> priorityQueue, int m) {
        int count = 1;
        while (true) {
            int value = priorityQueue.peek();

            if (value == queue.peek().num) {
                if (queue.peek().index == m) {
                    break;
                }

                ++count;
                priorityQueue.poll();
                queue.poll();
            } else if (value != queue.peek().num){
                queue.add(queue.poll());
            }
        }

        System.out.println(count);
    }

}

class Printer {

    int num;
    int index;

    public Printer(int num, int index) {
        this.num = num;
        this.index = index;
    }

}
