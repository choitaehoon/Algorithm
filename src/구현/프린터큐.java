package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프린터큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < caseNum; ++i) {
            StringTokenizer token1 = new StringTokenizer(buffer.readLine());
            StringTokenizer token2 = new StringTokenizer(buffer.readLine());
            int num = Integer.parseInt(token1.nextToken());
            int index = Integer.parseInt(token1.nextToken());
            int[] array = new int[num];

            for (int k = 0; k < num; ++k) {
                array[k] = Integer.parseInt(token2.nextToken());
            }

            solution(num, index, array);
        }
    }

    private static void solution(int num, int index, int[] array) {
        Queue<Location1> queue = new LinkedList<>();
        int[] reverse = new int[num];
        for (int i = 0; i < num; ++i) {
            queue.offer(new Location1(array[i], i));
        }

        int reverseIndex = num - 1;
        for (int i = 0; i < num; ++i) {
            reverse[i] = array[i];
        }
        Arrays.sort(reverse);

        int count = 0;
        while (!queue.isEmpty()) {
            if (queue.peek().num == reverse[reverseIndex]) {
                ++count;
                if (queue.peek().index == index) {
                    break;
                } else {
                    queue.poll();
                    --reverseIndex;
                }
            } else {
                queue.offer(queue.poll());
            }
        }

        System.out.println(count);
    }

}

class Location1 {

    int num;
    int index;

    public Location1(int num, int index) {
        this.num = num;
        this.index = index;
    }

}
