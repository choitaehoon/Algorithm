package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크 {

    static int[] cache = new int[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int F = Integer.parseInt(token.nextToken());
        int S = Integer.parseInt(token.nextToken());
        int G = Integer.parseInt(token.nextToken());
        int U = Integer.parseInt(token.nextToken());
        int D = Integer.parseInt(token.nextToken());

        solution(F, S, G, U, D);
    }

    private static void solution(int f, int s, int g, int u, int d) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        cache[s] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == g) {
                System.out.println(cache[now] - 1);
                return;
            }

            if (now + u <= f && cache[now + u] == 0) {
                cache[now + u] = cache[now] + 1;
                queue.offer(now + u);
            }

            if (now - d >= 1 && cache[now - d] == 0) {
                cache[now - d] = cache[now] + 1;
                queue.offer(now - d);
            }
        }

        System.out.println("use the stairs");
    }

}
