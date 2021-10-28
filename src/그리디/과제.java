package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 과제 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        HomeWork[] homeWork = new HomeWork[n];
        for (int i = 0; i < n; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int d = Integer.parseInt(token.nextToken());
            int w = Integer.parseInt(token.nextToken());

            homeWork[i] = new HomeWork(d, w);
        }
        Arrays.sort(homeWork, Comparator.comparingInt((HomeWork a) -> a.day)
                .thenComparingInt(a -> a.w));

        int timeMinus = homeWork[n - 1].day;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;

        for (int i = timeMinus, index = n - 1; i >= 1; --i) {
            while (index >= 0 && homeWork[index].day == i)
                queue.offer(homeWork[index--].w);
            if (!queue.isEmpty())
                sum += queue.poll();
        }

        System.out.println(sum);
    }

}

class HomeWork {

    int day;
    int w;

    public HomeWork(int day, int w) {
        this.day = day;
        this.w = w;
    }

}