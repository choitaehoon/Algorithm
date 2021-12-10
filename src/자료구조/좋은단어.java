package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 좋은단어 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        int sum = 0;

        for (int i = 0; i < givenNumber; ++i) {
            String word = buffer.readLine();
            sum += checkGoodWord(word);
        }

        System.out.println(sum);
    }

    private static int checkGoodWord(String word) {
        Stack<Character> stack = new Stack<>();

        for (char value : word.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(value);
            } else if (stack.peek() == value)
                stack.pop();
            else
                stack.push(value);
        }

        return stack.isEmpty() ? 1 : 0;
    }

}
