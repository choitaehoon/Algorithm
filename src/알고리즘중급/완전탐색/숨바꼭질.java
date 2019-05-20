package 알고리즘중급.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 숨바꼭질 {

    static final int MAX = 200001;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        boolean [] check = new boolean[MAX];
        int[] dist = new int[MAX];

        check[n] = true;
        queue.offer(n);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num -1 >= 0 && !check[num-1]) {
                queue.offer(num-1);
                check[num-1] = true;
                dist[num-1] = dist[num]+1;
            }

            if (num+1 < MAX && !check[num+1]) {
                queue.offer(num+1);
                check[num+1] = true;
                dist[num+1] = dist[num]+1;
            }

            if (num*2 < MAX && !check[num*2]) {
                queue.offer(num*2);
                check[num*2] = true;
                dist[num*2] = dist[num]+1;
            }
        }

        System.out.println(dist[m]);
    }

}
