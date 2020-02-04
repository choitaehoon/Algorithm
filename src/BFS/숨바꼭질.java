package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {

    static int[] edge = new int[200001];
    static boolean[] check = new boolean[200001];
    static final int MAX = 200001;
    static int subin;
    static int brother;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        subin = Integer.parseInt(token.nextToken());
        brother = Integer.parseInt(token.nextToken());

        queue.offer(subin);
        check[subin] = true;
        checkBFS();

        System.out.println(edge[brother]);
    }

    //큐 순환 하는 메소드
    private static void checkBFS() {

        while (!queue.isEmpty()) {
            int visit = queue.poll();

            if (visit - 1 >= 0 && !check[visit-1]) {
                check[visit-1] = true;
                queue.offer(visit - 1);
                edge[visit-1] = edge[visit] + 1;
            }

            if (visit + 1 < MAX && !check[visit+1]) {
                check[visit+1] = true;
                queue.offer(visit + 1);
                edge[visit+1] = edge[visit] + 1;
            }

            if (visit * 2 < MAX && !check[visit*2]) {
                check[visit*2] = true;
                queue.offer(visit * 2);
                edge[visit*2] = edge[visit] + 1;
            }
        }

    }

}
