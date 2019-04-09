package 큐;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
//        int bridge_length = 2;
//        int weight = 10;
//        int []truck_weights = {7,4,5,6};

        int bridge_length = 100;
        int weight = 100;
        int [] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(bridge_length,weight,truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<TruckWait> queue = new LinkedList<>();
        int weightIndex = 0;
        long passingWeight = 0;
        int time = 0;

        while (!(queue.isEmpty() && weightIndex == truck_weights.length)) {

            for (TruckWait truckWait : queue)
                truckWait.time--;

            if (!queue.isEmpty() && queue.peek().time == 0 )
                passingWeight -= queue.poll().truck;

            if (weightIndex < truck_weights.length && passingWeight+truck_weights[weightIndex] <= weight) {
                passingWeight += truck_weights[weightIndex];
                queue.offer(new TruckWait(truck_weights[weightIndex++], bridge_length));
            }

            ++time;
        }

        return time;
    }

}

class TruckWait {
    int truck;
    int time;

    public TruckWait(int truck, int time) {
        this.truck = truck;
        this.time = time;
    }
}