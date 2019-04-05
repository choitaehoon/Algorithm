package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값재풀이 {

    public static int sum;
    public static int multiple = 1;
    public static String[] temp;
    public static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        temp = buffer.readLine().split("");

        for (int i=0; i<temp.length; ++i) {
            if (temp[i].equals(")") && (stack.isEmpty() || !stack.peek().equals("("))) {
                System.out.println(0);
                return;
            }

            else if (temp[i].equals("]") && (stack.isEmpty() || !stack.peek().equals("["))) {
                System.out.println(0);
                return;
            }

            else if (temp[i].equals("(")) {
                multiple *= 2;
                stack.push("(");
            }

            else if (temp[i].equals("[")) {
                multiple *= 3;
                stack.push("[");
            }

            else if (temp[i].equals(")")) {
                if (temp[i-1].equals("("))
                    sum += multiple;

                stack.pop();
                multiple /= 2;
            }

            else if (temp[i].equals("]")) {
                if (temp[i-1].equals("["))
                    sum += multiple;
                stack.pop();
                multiple /= 3;
            }

        }

        if (!stack.isEmpty())
            System.out.println(0);
        else
            System.out.println(sum);

    }
}
