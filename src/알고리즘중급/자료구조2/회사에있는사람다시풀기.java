package 알고리즘중급.자료구조2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 회사에있는사람다시풀기 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            String name = token.nextToken();
            String accessibility = token.nextToken();

            if (accessibility.equals("enter")) {
                priorityQueue.add(name);
                continue;
            }

            priorityQueue.remove(name);
        }

        priorityQueue.comparator();


    }
}
