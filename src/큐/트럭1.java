package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트럭1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(token.nextToken());
        int w = Integer.parseInt(token.nextToken());
        int limit = Integer.parseInt(token.nextToken());
        StringTokenizer truck = new StringTokenizer(buffer.readLine());

        Queue<Integer> givenTruck = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            givenTruck.add(Integer.parseInt(truck.nextToken()));
        }

        Queue<TruckQueue> moveTruck = new LinkedList<>();
        int nowWeight = 0;
        int time = 0;

        while (true) {
            if (givenTruck.isEmpty() && moveTruck.isEmpty())
                break;

            if (!moveTruck.isEmpty() && moveTruck.peek().time == 0) {
                nowWeight -= moveTruck.poll().id;
            }

            if (!givenTruck.isEmpty() && nowWeight + givenTruck.peek() <= limit) {
                nowWeight += givenTruck.peek();
                moveTruck.add(new TruckQueue(givenTruck.poll(), w));
            }

            for (TruckQueue truckQueue : moveTruck)
                truckQueue.time--;

            ++time;
        }

        System.out.println(time);
    }

}

class TruckQueue {

    int id;
    int time;

    public TruckQueue(int id, int time) {
        this.id = id;
        this.time = time;
    }

}
