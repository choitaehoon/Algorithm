package 큐;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
//        int[] progresses = {99,93,93};
//        int[] speeds = {1,30,5};

        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        System.out.println(solution(progresses,speeds));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int[] array;

        for (int i=0; i<progresses.length; ++i) {
            int day = (100-progresses[i])%speeds[i] == 0 ? (100-progresses[i])/speeds[i]
                      :(100-progresses[i])/speeds[i]+1;
            queue.offer(day);
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            int sum = 1;

            while (!queue.isEmpty()) {
                if (pre >= queue.peek()) {
                    queue.poll();
                    ++sum;
                }
                else break;
            }
            list.add(sum);
        }

        array = new int[list.size()];
        for (int i=0; i<list.size(); ++i) {
            array[i] = list.get(i);
        }

        return array;
    }
}