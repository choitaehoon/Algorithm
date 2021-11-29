package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 가운데를말해요 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a1, a2) -> a1 - a2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a1, a2) -> a2 - a1);
        StringBuilder builder = new StringBuilder();

        for(int i = 0 ; i < n; i++){
            int num = Integer.parseInt(buffer.readLine());

            if(minHeap.size() == maxHeap.size()) maxHeap.offer(num);
            else minHeap.offer(num);

            if(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                int tmp = minHeap.poll();
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(tmp);
            }

            builder.append(maxHeap.peek()).append("\n");
        }
        System.out.println(builder);
    }

}
