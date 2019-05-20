package 알고리즘중급.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 소수경로 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int givenNumber = Integer.parseInt(buffer.readLine());
        Map<Integer,Integer> map = new HashMap<>();

        //미리 소수를 구해 둔다.
        for (int i = 2; i<=10000; ++i) {
            if (map.get(i) == null) {
                for (int j=i*2; j<=10000; j+=i){
                    map.put(j, 1);
                }
            }
        }

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());

            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            boolean[] check = new boolean[10001];
            int[] dist = new int[10001];
            Queue<Integer> queue = new LinkedList<>();

            check[a] = true;
            queue.offer(a);

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int j=0; j<4; ++j)
                    for (int k=0; k<10; ++k) {
                        int next = change(now,j,k);
                        if (next != -1 && !check[next] && map.get(next) == null) {
                            queue.offer(next);
                            check[next] = true;
                            dist[next] = dist[now] +1;
                        }
                    }
            }

            System.out.println(dist[b]);
        }

    }

    private static int change(int now, int index, int changeNumber) {
        if (index == 0 && changeNumber == 0)
            return -1;
        StringBuilder builder = new StringBuilder(String.valueOf(now));
        builder.setCharAt(index,(char)(changeNumber + 48));
        return Integer.parseInt(builder.toString());
    }
}
