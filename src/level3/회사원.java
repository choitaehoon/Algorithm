package level3;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class 회사원 {
    public static void main(String[] args) throws IOException {

        System.out.println(solution(1,new int[]{2,1,2}));

    }

    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int worksLength = works.length;
        for (int i=0; i<worksLength; ++i)
            priorityQueue.add(works[i]);

        for (int i=0; i<n; ++i) {
            int number = 0;

            if (priorityQueue.size() > 0) {
                number = priorityQueue.remove();
            }

            if (number -1 > 0)
                priorityQueue.add(--number);
        }

        int size = priorityQueue.size();
        long result = 0;

        for (int i=0; i<size; ++i)
            result += Math.pow(priorityQueue.remove(),2);

        return result;

    }
}
