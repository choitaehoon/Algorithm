package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            int nowNum = Integer.parseInt(buffer.readLine());
            if (nowNum == 0)
                stack.pop();
            else
                stack.push(nowNum);
        }

        int sum = 0;
        while (!stack.isEmpty())
            sum += stack.pop();

        System.out.println(sum);
    }

}
