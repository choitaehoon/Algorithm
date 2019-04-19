package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<10; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int n = Integer.parseInt(token.nextToken());
            String k = token.nextToken();

            for (int j=0; j<n; ++j) {
                if (!stack.isEmpty() && k.charAt(j) == stack.peek())
                    stack.pop();
                else
                    stack.push(k.charAt(j));
            }

            StringBuilder builder = new StringBuilder();
            while (!stack.isEmpty())
                builder.append(stack.pop());

            System.out.printf("#%d %s\n", i+1, builder.reverse().toString());
        }

    }
}
