package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        Stack<int[]> stack = new Stack<>();
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        for (int i = 0; i < givenNumber; ++i) {
            int value = Integer.parseInt(token.nextToken());

            while (!stack.isEmpty()) {
                if (stack.peek()[0] < value) {
                    stack.pop();
                } else {
                    System.out.print(stack.peek()[1]+" ");
                    break;
                }
            }

            if (stack.isEmpty())
                System.out.print("0 ");

            stack.push(new int[]{value, i + 1});
        }

    }

}
