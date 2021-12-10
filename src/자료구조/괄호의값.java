package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String word = buffer.readLine();

        resultParenthesis(word);
    }

    private static void resultParenthesis(String word) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        char [] temp = word.toCharArray();
        int tempLen = temp.length;
        int multiple = 1;

        for (int i = 0; i < tempLen; ++i) {
            char value = temp[i];

            if (i == 0 && (value == ']' || value == ')')) {
                System.out.println(0);
                return;
            }

            if (stack.isEmpty() && (value == ')' || value == ']')) {
                System.out.println(0);
                return;
            }

            if (value == '(') {
                multiple *= 2;
                stack.push('(');
            } else if (value == '[') {
                multiple *= 3;
                stack.push('[');
            } else if (value == ')') {
                if (temp[i - 1] == '(')
                    result += multiple;
                else if (stack.peek() == '[') {
                    System.out.println(0);
                    return;
                }

                stack.pop();
                multiple /= 2;
            } else if (value == ']') {
                if (temp[i - 1] == '[')
                    result += multiple;
                else if (stack.peek() == '(') {
                    System.out.println(0);
                    return;
                }

                stack.pop();
                multiple /= 3;
            }
        }

        if (!stack.isEmpty())
            System.out.println(0);
        else {
            System.out.println(result);
        }
    }

}
