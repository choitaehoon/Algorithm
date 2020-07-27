package medium;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {

    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            Stack<Character> stack = new Stack<>();
            boolean isCheck = true;

            for (int i = 0; i < input.length(); ++i) {
                char nowInput = input.charAt(i);
                if (nowInput == '{' || nowInput == '(' || nowInput == '[')
                    stack.push(nowInput);
                else if (!stack.isEmpty() &&
                        ((stack.peek() == '{' && nowInput == '}') || (stack.peek() == '(' && nowInput == ')') || (stack.peek() == '[' && nowInput == ']')))
                    stack.pop();
                else if (stack.isEmpty() && nowInput == '}' || nowInput == ')' || nowInput == ']') {
                    isCheck = false;
                    break;
                }
            }

            if (!stack.isEmpty())
                isCheck = false;

            System.out.println(isCheck);
        }

    }
}
