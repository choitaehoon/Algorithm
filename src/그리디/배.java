package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 배 {

    /*
    반례
        3
        6 8 9
        6
        2 2 4 5 9 9
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token1 = new StringTokenizer(buffer.readLine());
        int m = Integer.parseInt(buffer.readLine());
        StringTokenizer token2 = new StringTokenizer(buffer.readLine());

        int[] crane = new int[n];
        for (int i = 0; i < n; ++i) {
            crane[i] = Integer.parseInt(token1.nextToken());
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < m; ++i) {
            queue.offer(Integer.parseInt(token2.nextToken()));
        }

        solution(crane, queue);
    }

    private static void solution(int[] crane, PriorityQueue<Integer> queue) {
        Arrays.sort(crane);
        int craneLen = crane.length - 1;
        int time = 0;

        while (!queue.isEmpty()) {

            List<Integer> store = new ArrayList<>();

            for (int i = craneLen; i >= 0; --i) {
                if (queue.isEmpty()) {
                    if (store.size() > 0 && store.get(0) > crane[i]) {
                        System.out.println(-1);
                        return;
                    }

                    break;
                }

                if (i == craneLen) {
                    if (queue.peek() > crane[i]) {
                        System.out.println(-1);
                        return;
                    }
                }

                if (queue.peek() <= crane[i]) {
                    queue.poll();
                } else {
                    store.add(queue.poll());
                    ++i;
                }
            }

            for (Integer integer : store)
                queue.offer(integer);

            ++time;
        }

        System.out.println(time);
    }

}
