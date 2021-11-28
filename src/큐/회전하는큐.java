package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회전하는큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        Map<Integer, Boolean> extractionValue = new LinkedHashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        for (int i = 0; i < m; ++i) {
            int value = Integer.parseInt(tokenizer.nextToken());
            extractionValue.put(value, true);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; ++i)
            deque.add(i);

        calculateExtraction(deque, extractionValue, n, m);
    }

    private static void calculateExtraction(Deque<Integer> deque, Map<Integer, Boolean> extractionValue, int n, int m) {
        int sum = 0;

        for (Map.Entry<Integer, Boolean> extraction : extractionValue.entrySet()) {
            int key = extraction.getKey();

            if (hasFirstExtractionValue(deque, key)) {
                deque.removeFirst();
                continue;
            }

            int left = circleLeft(deque, key);
            int right = circleRight(deque, key);

            if (left > right) {
                for (int i = 0; i < right; ++i) {
                    deque.addFirst(deque.removeLast());
                    ++sum;
                }

                deque.removeFirst();
            } else {
                for (int i = 0; i < left - 1; ++i) {
                    deque.addLast(deque.removeFirst());
                    ++sum;
                }

                deque.removeFirst();
            }
        }

        System.out.println(sum);
    }

    private static boolean hasFirstExtractionValue(Deque<Integer> deque, int compareValue) {
        return deque.peekFirst() == compareValue;
    }

    private static int circleLeft(Deque<Integer> deque, int key) {
        int leftLocation = 0;
        for (Integer integer : deque) {
            ++leftLocation;

            if (integer == key)
                break;
        }

        return leftLocation;
    }

    private static int circleRight(Deque<Integer> deque, int key) {
        int rightLocation = 0;
        for (Iterator<Integer> it = deque.descendingIterator(); it.hasNext(); ) {
            Integer value = it.next();
            ++rightLocation;

            if (value == key)
                break;

        }

        return rightLocation;
    }

}
