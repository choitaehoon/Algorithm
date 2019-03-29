package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String ironBar = buffer.readLine();
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i=0; i<ironBar.length(); ++i) {
            if (ironBar.charAt(i) == '(') {
                stack.push(i);
                continue;
            }

            if (i - stack.peek() == 1) {
                stack.pop();
                sum += stack.size();
                continue;
            }

            stack.pop();
            sum += 1;
        }

        System.out.println(sum);
    }
}
