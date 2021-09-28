package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 컵라면 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int deadLine = Integer.parseInt(token.nextToken());
            int ramenCount = Integer.parseInt(token.nextToken());

            List<Integer> list = map.get(deadLine);
            if (list == null)
                list = new ArrayList<>();
            list.add(ramenCount);

            map.put(deadLine, list);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        List<Map.Entry<Integer, List<Integer>>> result = new ArrayList<>(map.entrySet());
        result.sort((a1, a2) -> a2.getKey() - a1.getKey());
        int sum = 0;

        for (Map.Entry<Integer, List<Integer>> integerListEntry : result) {
            List<Integer> nowList = integerListEntry.getValue();
            for (Integer value : nowList)
                queue.offer(value);
            if (!queue.isEmpty())
                sum += queue.poll();
        }

        System.out.println(sum);
    }

}
