package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질4 {

    static int[] array = new int[200001];
    static int[] dist = new int[200001];
    static int[] from = new int[200001];
    static boolean[] check = new boolean[200001];
    static Queue<Integer> queue = new LinkedList<>();
    static int start;
    static int arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        inputStartAndArriveAndQueue(token);
        searchQueue();
        System.out.println(dist[arrive]);
        fromPrint(start, arrive);
    }

    private static void inputStartAndArriveAndQueue(StringTokenizer token) {
        start = Integer.parseInt(token.nextToken());
        arrive = Integer.parseInt(token.nextToken());

        queue.offer(start);
        check[start] = true;
    }

    private static void searchQueue() {
        while (!queue.isEmpty()) {
            int standard = queue.poll();

            if (0 <= standard - 1 && !check[standard-1]) {
                dist[standard-1] = dist[standard] + 1;
                check[standard-1] = true;
                from[standard-1] = standard;
                queue.offer(standard-1);
            }

            if (standard + 1 < arrive && !check[standard+1]) {
                dist[standard+1] = dist[standard] + 1;
                check[standard+1] = true;
                from[standard+1] = standard;
                queue.offer(standard+1);
            }

            if (standard * 2 < arrive && !check[standard*2]) {
                dist[standard*2] = dist[standard] + 1;
                check[standard*2] = true;
                from[standard*2] = standard;
                queue.offer(standard*2);
            }
        }
    }

    private static void fromPrint(int n, int m) {
        if (n != m) {
            fromPrint(n, from[m]);
        }
        System.out.print(m+" ");
    }

}
