package 큐;

import java.util.*;

public class 괄호회전하기 {

    public int solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char value : s.toCharArray())
            queue.add(value);

        int sLen = s.length();
        int result = 0;
        for (int i = 0; i < sLen; ++i) {
            if (i != 0) {
                queue.offer(queue.poll());
            }

            result += searchCorrect(queue);
        }

        return result;
    }

    private int searchCorrect(Queue<Character> queue) {
        Stack<Character> stack = new Stack<>();
        for (char value : queue) {
            if (value == '[' || value == '(' || value == '{')
                stack.push(value);
            else {
                if (stack.isEmpty()) {
                    return 0;
                }

                if ((value == ']' && (stack.peek() != '['))
                        || (value == ')' && stack.peek() != '(')
                        || (value == '}' && stack.peek() != '{'))
                    return 0;

                stack.pop();
            }
        }

        if (!stack.isEmpty())
            return 0;

        return 1;
    }

}
