package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("all")
public class 음악프로그램 {

    static int N;
    static int E;
    static List<List<Integer>> nodeArray = new ArrayList<>();
    static int[] nodeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        N = Integer.parseInt(token.nextToken());
        E = Integer.parseInt(token.nextToken());
        nodeCount = new int[N + 1];

        for (int i = 0; i <= N; ++i)
            nodeArray.add(new ArrayList<>());

        for (int i = 0; i < E; ++i) {
            String[] node = buffer.readLine().split(" ");
            int givenPd = Integer.parseInt(node[0]);

            for (int k = 1; k < givenPd; ++k) {
                int v1 = Integer.parseInt(node[k]);
                int v2 = Integer.parseInt(node[k + 1]);

                nodeArray.get(v1).add(v2);
                nodeCount[v2]++;
            }
        }

        musicOrder();
    }

    private static void musicOrder() {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; ++i) {
            if (nodeCount[i] == 0)
                queue.offer(i);
        }

        for (int i = 1; i <= N; ++i) {
            if (queue.isEmpty()) {
                System.out.println(0);
                return;
            }

            int v = queue.remove();
            result.add(v);

            for (int nextV : nodeArray.get(v)) {
                nodeCount[nextV]--;

                if (nodeCount[nextV] == 0)
                    queue.offer(nextV);
            }

        }

        int len = result.size();
        for (int i = 0; i < len; ++i)
            System.out.println(result.get(i));
    }

}
