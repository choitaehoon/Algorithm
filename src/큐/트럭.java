package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트럭 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        StringTokenizer truck = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int w = Integer.parseInt(token.nextToken());
        int l = Integer.parseInt(token.nextToken());

        Queue<Bridge> queue = new LinkedList<>();
        Queue<Bridge> nowBridge = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            queue.offer(new Bridge(Integer.parseInt(truck.nextToken()), w));
        }

        int time = 0;
        int nowWeight = 0;
        while (true) {
            ++time;

            for (Bridge bridge : nowBridge) {
                bridge.len--;
            }

            while (!nowBridge.isEmpty() && nowBridge.peek().len <= 0) {
                nowWeight -= nowBridge.poll().weight;
            }

            if (!queue.isEmpty() && nowWeight + queue.peek().weight <= l) {
                Bridge bridge = queue.poll();
                nowBridge.offer(bridge);
                nowWeight += bridge.weight;
            }

            if (queue.isEmpty() && nowBridge.isEmpty())
                break;
        }

        System.out.println(time);
    }

}

class Bridge {

    int weight;
    int len;

    public Bridge(int weight, int len) {
        this.weight = weight;
        this.len = len;
    }

    public String toString() {
        return this.weight+" "+this.len;
    }
}
