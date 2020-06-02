package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String word = buffer.readLine();

        while (!word.equals(".")) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) == '(' || word.charAt(i) == '[') {
                    stack.push(word.charAt(i));
                } else if (!stack.isEmpty() && stack.peek() == '(' && word.charAt(i) == ')') {
                    stack.pop();
                } else if (!stack.isEmpty() && stack.peek() == '[' && word.charAt(i) == ']') {
                    stack.pop();
                } else if ((!stack.isEmpty() && stack.peek() == '(' && word.charAt(i) == ']')
                                || (!stack.isEmpty() && stack.peek() == '[' && word.charAt(i) == ')')
                                || (stack.isEmpty() && (word.charAt(i) == ')' || word.charAt(i) == ']'))) {
                    stack.push(']');
                    break;
                }
            }

            System.out.println(stack.isEmpty() ? "yes" : "no");
            word = buffer.readLine();
        }
    }

}
