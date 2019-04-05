package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            String[] temp = buffer.readLine().split("");
            Stack<String> stack = new Stack<>();
            boolean check = false;

            for (int j=0; j<temp.length; ++j) {
                if (temp[j].equals("("))
                    stack.push("(");
                else
                    if (stack.isEmpty() && temp[j].equals(")")) {
                        check = true;
                        break;
                    }
                    else
                        stack.pop();
            }

            System.out.println(!stack.isEmpty() || check ? "NO" : "YES");
        }

    }
}
