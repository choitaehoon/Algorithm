package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값 {

    static Stack<String> stack = new Stack<>();
    static int multiplyParentheses = 1;
    static int sumParentheses ;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] valueInParentheses = buffer.readLine().split("");

        for (int i=0; i<valueInParentheses.length; ++i) {

            if (valueInParentheses[i].equals("(")) {
                stack.push("(");
                multiplyParentheses *= 2;
                continue;
            }

            else if (valueInParentheses[i].equals("[")) {
                stack.push("[");
                multiplyParentheses *= 3;
                continue;
            }

            //불가능 한 경우
            else if (valueInParentheses[i].equals(")") && (stack.isEmpty() || !stack.peek().equals("(") )) {
                System.out.println(0);
                return;
            }

            //불가능 한 경우
            else if (valueInParentheses[i].equals("]") && (stack.isEmpty() || !stack.peek().equals("["))) {
                System.out.println(0);
                return;
            }

            else if (valueInParentheses[i].equals(")")) {
                if (valueInParentheses[i-1].equals("("))
                    sumParentheses += multiplyParentheses;
                stack.pop();
                multiplyParentheses /= 2;
            }

            else if (valueInParentheses[i].equals("]")) {
                if (valueInParentheses[i-1].equals("["))
                    sumParentheses += multiplyParentheses;
                stack.pop();
                multiplyParentheses /= 3;
            }

        }

        if (!stack.isEmpty())
            System.out.println(0);
        else
            System.out.println(sumParentheses);
    }
}
