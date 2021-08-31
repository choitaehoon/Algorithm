package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 크게만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        int[] array = createArray(buffer.readLine().toCharArray());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int num : array) {
            while (k > 0 && !deque.isEmpty() && deque.peekLast() < num) {
                --k;
                deque.removeLast();
            }

            deque.add(num);
        }

        StringBuilder builder = new StringBuilder();
        int len = deque.size() - k;
        for (int i = 0; i < len; ++i)
            builder.append(deque.removeFirst());

        System.out.println(builder);
    }

    private static int[] createArray(char[] toCharArray) {
        int[] array = new int[toCharArray.length];

        for (int i = 0; i < array.length; ++i) {
            array[i] = Integer.parseInt(String.valueOf(toCharArray[i]));
        }

        return array;
    }

}
