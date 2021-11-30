package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < givenNumber; ++i) {
            int value = Integer.parseInt(buffer.readLine());

            if (value == 0) {
                if (queue.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(queue.poll());
            } else {
                queue.add(value);
            }
        }

    }

}
