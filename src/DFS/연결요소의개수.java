package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연결요소의개수 {

    static boolean[] visit;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        visit = new boolean[n + 1];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; ++i)
            map.put(i, new ArrayList<>());

        for (int i = 0; i < k; ++i) {
            StringTokenizer token2 = new StringTokenizer(buffer.readLine());
            int start = Integer.parseInt(token2.nextToken());
            int end = Integer.parseInt(token2.nextToken());

            List<Integer> list = map.get(start);
            list.add(end);
            map.put(start, list);

            List<Integer> list2 = map.get(end);
            list2.add(start);
            map.put(end, list2);
        }

        for (int i = 1; i <= n; ++i) {
            if (!visit[i]) {
                ++count;
                dfs(i, map);
            }
        }

        System.out.println(count);
    }

    private static void dfs(int index, Map<Integer, List<Integer>> map) {
        visit[index] = true;

        for (Integer num : map.get(index)) {
            if (!visit[num]) {
                dfs(num, map);
            }
        }
    }

}
