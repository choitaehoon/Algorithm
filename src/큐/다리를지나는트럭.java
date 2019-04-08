package 큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};
//        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
//        int[] truck_weights = {7,4,5,6};
        System.out.println(solution(bridge_length,weight,truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Point> queue = new LinkedList<>();
        Vector<Integer> vector = new Vector<>();
        int weightSum = 0;

        for (int i=0; i<truck_weights.length; ++i)
            vector.add( truck_weights[i] );

        while (!(queue.isEmpty() && vector.size() == 0)) {

            if (!queue.isEmpty() && queue.peek().time == 0) {
                weightSum -= queue.poll().truckWeight;
            }

            //다리에 무게가 견딜 수 있으면 받기
            if ( vector.size() != 0 && vector.get(0)+weightSum < weight) {
                int sum = vector.get(0);
                queue.offer(new Point(vector.remove(0), bridge_length));
                weightSum += sum;
            }


            //큐에서 돌면서 시간 추가 하기
            int size = queue.size();
            for (int i=0; i<size; ++i) {
                Point point = queue.poll();
                queue.offer(new Point(point.truckWeight, --point.time));
            }

            ++time;
        }

        return time;
    }
}

class Point {
    int truckWeight;
    int time;

    public Point(int truckWeight, int time) {
        this.truckWeight = truckWeight;
        this.time = time;
    }
}
