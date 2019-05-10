package study.기초;

import java.io.*;
import java.util.Stack;

@SuppressWarnings("Duplicates")
public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int givenNumber = Integer.parseInt(buffer.readLine());
        for (int i=0; i<givenNumber; ++i) {
            Stack<Character> stack = new Stack<>();
            String parenthesis = buffer.readLine();

            int parenthesisLength = parenthesis.length();
            boolean check = false;
            for (int j=0; j<parenthesisLength; ++j) {
                if (parenthesis.charAt(j) == '(') {
                    stack.push('(');
                    continue;
                }
                if (parenthesis.charAt(j) == ')' && stack.isEmpty()) {
                    check = true;
                    break;
                }
                stack.pop();
            }

            if (!check && stack.isEmpty())
                writer.write("YES"+"\n");
            else
                writer.write("NO"+"\n");
        }

        writer.close();

    }
}
