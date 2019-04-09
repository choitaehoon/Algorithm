package 큐;

import java.util.Vector;

public class 지나가는트럭배열로풀기 {
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int [] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(bridge_length,weight,truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Vector<TruckWait> vector = new Vector<>();
        for (int i=0; i<truck_weights.length; ++i)
            vector.add(new TruckWait(truck_weights[i], bridge_length));

        int index = 0;
        int time = 0;
        int weightSum = 0;

        while (vector.size() != 0 && index != truck_weights.length) {

            if (vector.size() != 0 && vector.get(0).time == 0)
                weightSum -= vector.remove(0).truck;

            if (index != truck_weights.length && weightSum+truck_weights[index] < weight ) {
                weightSum += truck_weights[index++];
                time += 1;
                vector.get(0).time--;
            }
            else {
                time += vector.remove(0).time;
            }


        }

        return time;
    }
}
class Truck {
    int truck;
    int time;

    public Truck(int truck, int time) {
        this.truck = truck;
        this.time =time;
    }
}