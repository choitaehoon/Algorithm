package 알고리즘중급.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 퍼즐 {

    static int[] xMove = {-1,1,0,0};
    static int[] yMove = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int start = 0;
                for (int i=0; i<3; ++i) {
                    StringTokenizer token = new StringTokenizer(buffer.readLine());
                    for (int j=0; j<3; ++j) {
                        int number = Integer.parseInt(token.nextToken());
                        if (number == 0)
                            number = 9;
                start = start*10 + number;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();

        map.put(start,0);
        queue.offer(start);

        while (!queue.isEmpty()) {
            String now = String.valueOf(queue.remove());
            int divide = now.indexOf('9');

            int x = divide/3;
            int y = divide%3;

            for (int i=0; i<4; ++i) {
                int xGo = x + xMove[i];
                int yGo = y + yMove[i];

                if (xGo < 0 || xGo >= 3 || yGo < 0 || yGo >= 3)
                    continue;

                StringBuilder builder = new StringBuilder(now);
                builder.setCharAt(x*3+y, builder.charAt(xGo*3+yGo));
                builder.setCharAt(xGo*3+yGo, '9');
                int num = Integer.parseInt(builder.toString());
                if (!map.containsKey(num)) {
                    map.put(num, map.get(Integer.parseInt(now))+1);
                    queue.offer(num);
                }

            }
        }

        if (map.containsKey(123456789))
            System.out.println(map.get(123456789));
        else
            System.out.println(-1);
    }

}