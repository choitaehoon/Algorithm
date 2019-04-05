package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열 {

    static int[] givenArray ;

    static Stack<Integer> stack = new Stack<>();
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        givenArray = new int[givenNumber];
        int index = 0;

        for (int i=0; i<givenNumber; ++i) {
            int number = Integer.parseInt(buffer.readLine());
            givenArray[i] = number;
        }

        for (int i=1; i <= givenNumber; ++i) {
            stack.push(i);
            builder.append("+\n");

            while (!stack.isEmpty() && stack.peek() == givenArray[index]) {
                index++;
                stack.pop();
                builder.append("-\n");
            }
        }

        if (!stack.isEmpty())
            System.out.println("NO");
        else
            System.out.println(builder);
    }
}
