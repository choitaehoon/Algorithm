package 시뮬레이션;

import java.io.*;
import java.util.*;

public class 프린터큐 {

    public static void main(String[] args) throws IOException {
        inputGivenNumber();
    }

    private static void inputGivenNumber() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token =
                    new StringTokenizer(buffer.readLine());
            StringTokenizer queueToken =
                    new StringTokenizer(buffer.readLine());

            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());
            queueInsert(queueToken, n, m);
        }
    }

    private static void queueInsert(StringTokenizer queueToken, int n, int m){
        Queue<Point> queue = new LinkedList<>();

        for (int i=0; i<n; ++i) {
            int number = Integer.parseInt(queueToken.nextToken());

            queue.offer(new Point(number, i));

        }

        checkQueue(queue, m);
    }

    private static void checkQueue(Queue<Point> queue, int m) {
        int sum = 1;

        while (true) {
            if (checkImportance(queue)) {
                if (Objects.requireNonNull(queue.poll()).importance == m) {
                    System.out.println(sum);
                    return ;
                }
                else
                    ++sum;
            }

        }
    }

    private static boolean checkImportance(Queue<Point> queue) {
        Iterator<Point> iterator = queue.iterator();
        int temp = iterator.next().x;

        while (iterator.hasNext()) {
            if (temp < iterator.next().x) {
                queue.offer(queue.poll());
                return false;
            }
        }

        return true;
    }

}

class Point {
    int x;
    int importance;

    public Point(int x, int y) {
        this.x = x;
        this.importance = y;
    }
}