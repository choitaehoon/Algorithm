package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AtoB {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        long start = Long.parseLong(token.nextToken());
        long end = Long.parseLong(token.nextToken());

        Queue<QueueMove> queue = new LinkedList<>();
        queue.add(new QueueMove(start, 1));
        boolean check = false;
        int result = 0;
        while (!queue.isEmpty()) {
            QueueMove nowQueue = queue.poll();
            long nowValue = nowQueue.num;
            int nowCount = nowQueue.count;

            if (nowValue == end) {
                result = nowCount;
                check = true;
                break;
            }

            if (nowValue * 2 <= end) {
                queue.offer(new QueueMove(nowValue * 2, nowCount + 1));
            }

            if ((nowValue * 10) + 1 <= end) {
                queue.offer(new QueueMove((nowValue * 10) + 1, nowCount + 1));
            }
        }

        if (check) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

}

class QueueMove {

    long num;
    int count;

    public QueueMove(long num, int count) {
        this.num = num;
        this.count = count;
    }

}
