package study.기초;

import java.io.*;
import java.util.Stack;

/*
* BufferedWriter는 숫자로 적으면 아스키코드롤 반환한다.
* */

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String parenthesis = buffer.readLine();
        Stack<Integer> stack = new Stack<>();

        int parenthesisLength = parenthesis.length();
        int sum = 0;
        for (int i=0; i<parenthesisLength; ++i) {
            if (parenthesis.charAt(i) == '(') {
                stack.push(i);
                continue;
            }

            else if (i - stack.peek() == 1) {
                stack.pop();
                sum += stack.size();
                continue;
            }

            stack.pop();
            sum += 1;
        }

        writer.write(sum+"");
        writer.close();

    }
}
