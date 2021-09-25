package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 요세푸스 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; ++i)
            queue.offer(i);

        solution(queue, k);
    }

    private static void solution(Queue<Integer> queue, int k) {
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; ++i) {
                queue.offer(queue.poll());
            }

            list.add(queue.poll());
        }

        printGO(list);
    }

    private static void printGO(List<Integer> list) {
        System.out.print("<");
        for (int i = 0; i < list.size(); ++i) {
            if (i != list.size() - 1)
                System.out.print(list.get(i)+", ");
            else
                System.out.print(list.get(i));
        }
        System.out.print(">");
    }

}
