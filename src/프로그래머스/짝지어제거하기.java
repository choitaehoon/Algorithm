package 프로그래머스;

import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        System.out.println(solution("cdcd"));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        int sLength = s.length();
        for (int i=0; i<sLength; ++i) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.peek() == s.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }

        return stack.isEmpty() ?  1 : 0;
    }
}
