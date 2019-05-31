package study.기초;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();

        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            String[] store = buffer.readLine().split(" ");

            switch (store[0]) {
                case "push" :
                    queue.offer(Integer.parseInt(store[1]));
                    break;
                case "pop" :
                    writer.write(!queue.isEmpty() ? queue.poll()+"\n" : -1+"\n");
                    break;
                case "size" :
                    writer.write(queue.size()+"\n");
                    break;
                case "empty" :
                    writer.write(queue.isEmpty() ? 1+"\n" : 0+"\n");
                    break;
                case "front" :
                    writer.write(!queue.isEmpty() ? queue.peek()+"\n" : -1+"\n");
                    break;
                case "back" :
                    if (queue.isEmpty())
                        writer.write(-1+"\n");
                    else {
                        int size = queue.size() - 1;
                        for (int j=0; j<size; ++j)
                            queue.offer(queue.poll());
                        writer.write(queue.peek()+"\n");
                        queue.offer(queue.poll());
                    }
            }

        }

        writer.close();

    }
}
