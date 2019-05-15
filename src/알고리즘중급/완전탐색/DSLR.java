package 알고리즘중급.완전탐색;

import java.io.*;
import java.util.*;

@SuppressWarnings("Duplicates")
public class DSLR {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());

            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());
            Queue<Integer> queue = new LinkedList<>();

            boolean[] check = new boolean[10001];
            char[] vertical = new char[10001];
            int[] store = new int[10001];

            check[A] = true;
            store[A] = -1;
            queue.offer(A);

            while (!queue.isEmpty()) {
                int number = queue.poll();

                // D 연산
                int next = (number * 2) % 10000;
                if (!check[next]) {
                    queue.offer(next);
                    check[next] = true;
                    vertical[next] = 'D';
                    store[next] = number;
                }

                // S 연산
                next = number - 1 == -1 ? 9999 : number - 1;
                if (!check[next]) {
                    queue.offer(next);
                    check[next] = true;
                    vertical[next] = 'S';
                    store[next] = number;
                }

                // L 연산
                next = (number % 1000) * 10 + (number / 1000);
                if (!check[next]) {
                    queue.offer(next);
                    check[next] = true;
//                    dist[next] = dist[number]+1;
                    vertical[next] = 'L';
                    store[next] = number;
                }

                // R 연산
                next = (number / 10) + (number % 10) * 1000;
                if (!check[next]) {
                    queue.offer(next);
                    check[next] = true;
//                    dist[next] = dist[number]+1;
                    vertical[next] = 'R';
                    store[next] = number;
                }
            }

            StringBuilder builder = new StringBuilder();
            while (B != A) {
                builder.append(vertical[B]);
                B = store[B];
            }

            System.out.println(builder.reverse());
        }
    }
}
