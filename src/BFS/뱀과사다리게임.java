package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀과사다리게임 {

    static int[] move = {1, 2, 3, 4, 5, 6};
    static int[] search = new int[101];
    static int[] d = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        for (int i = 0; i < n; ++i) {
            StringTokenizer to = new StringTokenizer(buffer.readLine());
            search[Integer.parseInt(to.nextToken())] = Integer.parseInt(to.nextToken());
        }

        for (int i = 0; i < k; ++i) {
            StringTokenizer to = new StringTokenizer(buffer.readLine());
            search[Integer.parseInt(to.nextToken())] =  Integer.parseInt(to.nextToken());
        }

        Arrays.fill(d, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        d[1] = 0;
        solution(queue);

        System.out.println(d[100]);
    }

    private static void solution(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (int i = 0; i < 6; ++i) {
                int go = num + move[i];

                if (go < 0 || go >= 101)
                    continue;

                if (search[go] != 0) {
                    go = search[go];
                }

                if (d[go] == -1) {
                    d[go] = d[num] + 1;
                    queue.offer(go);
                }
            }
        }
    }

}