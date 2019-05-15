package study.중급;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

@SuppressWarnings("Duplicates")
public class 최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int givenNumber = Integer.parseInt(buffer.readLine());
        for (int i=0; i<givenNumber; ++i) {
            int number = Integer.parseInt(buffer.readLine());

            if (number == 0 && priorityQueue.size() == 0) {
                writer.write(0+"\n");
                continue;
            }

            if (number == 0) {
                writer.write(priorityQueue.remove()+"\n");
                continue;
            }

            priorityQueue.add(number);
        }

        writer.close();
    }
}
