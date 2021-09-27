package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 보석도둑 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        Jewel[] jewels = new Jewel[n];
        int[] bag = new int[k];

        for (int i = 0; i < n; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
            int weight = Integer.parseInt(tokenizer.nextToken());
            int price = Integer.parseInt(tokenizer.nextToken());
            jewels[i] = new Jewel(weight, price);
        }

        for (int i = 0; i < k; ++i) {
            bag[i] = Integer.parseInt(buffer.readLine());
        }

        searchGo(jewels, bag, n, k);
    }

    private static void searchGo(Jewel[] jewels, int[] bag, int n, int k) {
        Arrays.sort(jewels);
        Arrays.sort(bag);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;

        for (int i = 0, jewelIndex = 0; i < k; ++i) {
            while (jewelIndex < n && jewels[jewelIndex].weight <= bag[i]) {
                queue.offer(jewels[jewelIndex].price);
                ++jewelIndex;
            }
            if (!queue.isEmpty())
                sum += queue.poll();
        }

        System.out.println(sum);
    }

}

class Jewel implements Comparable<Jewel> {
    int weight;
    int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewel jewel) {
        return this.weight - jewel.weight;
    }

}