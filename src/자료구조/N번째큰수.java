package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            offerValue(queue, token, givenNumber);
        }

        printResult(queue, givenNumber);
    }

    private static void offerValue(PriorityQueue<Integer> queue, StringTokenizer token, int givenNumber) {
        for (int i = 0; i < givenNumber; ++i) {
            int value = Integer.parseInt(token.nextToken());

            if (queue.size() < givenNumber)
                queue.add(value);
            else {
                if (value > queue.peek()) {
                    queue.poll();
                    queue.add(value);
                }
            }
        }
    }

    private static void printResult(PriorityQueue<Integer> queue, int givenNumber) {
        System.out.println(queue.peek());
    }

}
