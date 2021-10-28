package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 크게만들기3 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        int minusK = k;
        Deque<Integer> deque = new ArrayDeque<>();

        char[] temp = buffer.readLine().toCharArray();
        for (int i = 0; i < n; ++i) {
            int nowNum = Integer.parseInt(String.valueOf(temp[i]));
            while (!deque.isEmpty() && k > 0 && deque.peekLast() < nowNum) {
                deque.pollLast();
                --k;
            }

            deque.addLast(nowNum);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n - minusK; ++i) {
            result.append(deque.pollFirst());
        }

        System.out.println(result);
    }

}
