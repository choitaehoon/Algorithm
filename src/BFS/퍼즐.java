package BFS;

import java.io.*;
import java.util.*;

public class 퍼즐 {

    static Queue<Integer> queue = new LinkedList<>();
    static Map<Integer, Integer> map = new HashMap<>();
    static int start;
    static int[] xMove = {-1,0,1,0};
    static int[] yMove = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        inputPuzzleNumberAndQueue(buffer);
        searchQueue();
        printPuzzle();
    }

    private static void inputPuzzleNumberAndQueue(BufferedReader buffer) throws IOException {
        for (int i=0; i<3; ++i) {
            StringTokenizer token =
                    new StringTokenizer(buffer.readLine());

            for (int j=0; j<3; ++j) {
                int number = Integer.parseInt(token.nextToken());

                if (number == 0) {
                    number = 9;
                }

                start = start * 10 + number;
            }
        }
        queue.offer(start);
        map.put(start, 0);
    }

    private static void searchQueue() {
        while (!queue.isEmpty()) {

            StringBuilder builder = new StringBuilder();
            int now = queue.poll();
            builder.append(now);
            int nineIndex = builder.indexOf("9");

            availableNumber(nineIndex, now);
        }
    }

    private static void availableNumber(int nineIndex, int now) {

        int x = nineIndex / 3;
        int y = nineIndex % 3;

        for (int i=0; i<4; ++i) {
            int xGo = x + xMove[i];
            int yGo = y + yMove[i];

            if (xGo < 0 || xGo >= 3 || yGo < 0 || yGo >= 3)
                continue;

            changeNumber(x, y, xGo, yGo, now);
        }

    }

    private static void changeNumber(int x, int y, int xGo, int yGo, int now) {
        StringBuilder builder = new StringBuilder();
        builder.append(now);
        builder.setCharAt(x*3+y, builder.charAt(xGo*3+yGo));
        builder.setCharAt(xGo*3+yGo, '9');

        int number = Integer.parseInt(builder.toString());
        if (!map.containsKey(number)) {
            queue.offer(number);
            map.put(number, map.get(now) + 1);
        }
    }

    private static void printPuzzle() {
        if (map.containsKey(123456789)) {
            System.out.println(map.get(123456789));
        } else {
            System.out.println(-1);
        }
    }

}
