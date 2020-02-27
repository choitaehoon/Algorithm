package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회전하는큐 {

    static List<Integer> list = new ArrayList<>();
    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token1 =
                new StringTokenizer(buffer.readLine());
        StringTokenizer token2 =
                new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token1.nextToken());
        int m = Integer.parseInt(token1.nextToken());

        for (int i=0; i<m; ++i) {
            list.add(Integer.parseInt(token2.nextToken()));
        }

        System.out.println(solution(n, list));
    }

    public static int solution(int n, List<Integer> list) {
        deque = dequeAdd(n);
        int sum = 0;

        while (!list.isEmpty()) {
            int left = leftRemove(list.get(0));
            int right = rightRemove(list.get(0));

            if (deque.peek() == list.get(0)) {
                deque.removeFirst();
            } else if (left < right) {
                sum += left;
                leftToMove(left);
            } else {
                sum += right;
                rightToMove(right);
            }

            list.remove(0);
        }

        return sum;
    }

    private static void rightToMove(int right) {
        for (int i=0; i<right; ++i)
            deque.addFirst(deque.removeLast());
        deque.removeFirst();
    }

    private static void leftToMove(int left) {
        for (int i=0; i<left; ++i)
            deque.addLast(deque.removeFirst());
        deque.removeFirst();
    }

    private static int leftRemove(Integer integer) {
        int sum = 0;
        Iterator<Integer> iterator = deque.iterator();

        while (iterator.hasNext()) {
            ++sum;
            if (integer == iterator.next())
                break;

        }

        return sum - 1;
    }

    private static int rightRemove(Integer integer) {
        int sum = 0;
        Iterator<Integer> iterator = deque.descendingIterator();

        while (iterator.hasNext()) {
            ++sum;
            if (integer == iterator.next())
                break;
        }

        return sum;
    }

    private static Deque<Integer> dequeAdd(int n) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=1; i<=n; ++i)
            deque.add(i);

        return deque;
    }
}
