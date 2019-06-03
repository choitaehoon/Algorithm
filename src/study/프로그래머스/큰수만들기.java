package study.프로그래머스;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 큰수만들기 {
    public static void main(String[] args) {
//        System.out.println(solution("4177252841",4));
//        System.out.println(solution("1231234",3));
        System.out.println(solution("00000",2));
    }

    public static String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        char[] result = new char[number.length() - k];

        for (int i=0; i<number.length(); ++i) {
            while (!stack.isEmpty() && stack.peek() < number.charAt(i) && k-- > 0)
                stack.pop();
            stack.push(number.charAt(i));
        }

        for (int i=0; i<result.length; ++i)
            result[i] = stack.get(i);

        return new String(result);
    }
}
