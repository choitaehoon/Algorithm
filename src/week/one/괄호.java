package week.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            System.out.println(checkVPS(buffer.readLine()));
        }

    }

    /**
     * 닫힌 괄호 일 때 -> 스택이 비어 있거나 스택에서 꺼 냈을 때 닫힌 괄호가 있을 때
     * 열린 괄호 일 때 -> 열린 괄호 이면 스택에 삽입, 닫힌 괄호일 때 pop
     * @param readLine
     * @return
     */
    private static String checkVPS(String readLine) {
        int size = readLine.length();
        Stack<Character> stack = new Stack<>();

        boolean result = false;
        for (int i=0; i < size; ++i) {
            if (readLine.charAt(i) == '(') {
                stack.push('(');
                continue;
            } if (readLine.charAt(i) == ')' && stack.empty()) {
                result = true;
                break;
            }
            stack.pop();
        }

        return !result && stack.empty() ? "YES" : "NO";
    }

}
