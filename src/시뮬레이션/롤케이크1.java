package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 롤케이크1 {

    static int L;
    static int N;
    static int[] array;
    static Map<Integer, Integer> expectPerson = new HashMap<>();
    static Map<Integer, Integer> storeCake = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(buffer.readLine());
        N = Integer.parseInt(buffer.readLine());
        array = new int[1001];

        for (int i = 1; i <= N; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());

            expectPerson.put(i, end - start + 1);

            for ( ; start <= end; ++start) {
                if (array[start] == 0) {
                    array[start] = i;
                    storeCake.put(i, storeCake.getOrDefault(i, 0) + 1);
                }
            }
        }

        List<Map.Entry<Integer, Integer>> expectPersonList = new ArrayList<>(expectPerson.entrySet());
        List<Map.Entry<Integer, Integer>> storeCakeList = new ArrayList<>(storeCake.entrySet());

        expectPersonList.sort((a1, a2) -> {
            int r = a2.getValue() - a1.getValue();
            if (r != 0) return r;

            return a1.getKey() - a2.getKey();
        });

        storeCakeList.sort((a1, a2) -> {
            int r = a2.getValue() - a1.getValue();
            if (r != 0) return r;

            return a1.getKey() - a2.getKey();
        });
        
        System.out.println(expectPersonList.get(0).getKey());
        System.out.println(storeCakeList.get(0).getKey());
    }

}
