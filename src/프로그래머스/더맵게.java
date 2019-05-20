package 프로그래머스;

import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int sum = 0;

        for (int data : scoville)
            priorityQueue.add(data);

        while (!priorityQueue.isEmpty() && priorityQueue.peek() < K) {
            if (priorityQueue.size() < 2) {
                sum = -1;
                break;
            }

            int a = priorityQueue.remove();
            int b = priorityQueue.remove() * 2;
            priorityQueue.add(a+b);
            ++sum;
        }

        return sum;
    }
}
