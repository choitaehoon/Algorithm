package study.프로그래머스;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 예상대진표 {
    public static void main(String[] args) {
        System.out.println(solution(8,4,7));
    }

    public static int solution(int n, int a, int b)
    {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        //큐에 삽입
        for (int i=1; i<=n; ++i)
            queue.offer(i);

        while (!queue.isEmpty()) {
            int size = queue.size() / 2;
            count++;

            for (int i=0; i<size; ++i) {
                int temp1 = queue.poll();
                int temp2 = queue.poll();

                if ((temp1 == a && temp2 == b) || (temp1 == b && temp2 == a))
                    break;

                else if (temp1 == a || temp1 == b)
                    queue.offer(temp1);

                else if (temp1 == b || temp2 == a)
                    queue.offer(temp2);

                else
                    queue.offer(temp2);
            }

        }

        return count;
    }

}
