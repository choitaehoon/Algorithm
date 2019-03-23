package 알고리즘기초.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<number; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            String temp = token.nextToken();

            if (temp.equals("push"))
                queue.offer(Integer.parseInt(token.nextToken()));

            else if (temp.equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(queue.poll());
            }

            else if (temp.equals("size"))
                System.out.println(queue.size());

            else if (temp.equals("empty"))
                System.out.println(queue.isEmpty() ? 1 : 0);

            else if (temp.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(queue.peek());
            }

            else {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(((LinkedList<Integer>) queue).peekLast());
            }

        }

    }
}
