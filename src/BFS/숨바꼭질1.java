package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질1 {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        System.out.println(solution(n, k));
    }

    private static int solution(int n, int k) {
        boolean[] check = new boolean[2000001];
        int[] location = new int[2000001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        check[n] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num - 1 >= 0 && !check[num - 1]) {
                check[num - 1] = true;
                location[num - 1] = location[num] + 1;
                queue.offer(num - 1);
            }

            if (num + 1 <= 200001 && !check[num + 1]) {
                check[num + 1] = true;
                location[num + 1] = location[num] + 1;
                queue.offer(num + 1);
            }

            if (num * 2 <= 200001 && !check[num * 2]) {
                check[num * 2] = true;
                location[num * 2] = location[num] + 1;
                queue.offer(num * 2);
            }
        }

        return location[k];
    }


}
