package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 좋은단어 {

    static int givenNumber;
    static int sum;

    public static void main(String[] args) throws IOException {
        inputGivenNumber();
        printGood();
    }

    private static void inputGivenNumber() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());

        checkWord(buffer);
    }

    private static void checkWord(BufferedReader buffer) throws IOException {
        for (int i=0; i<givenNumber; ++i) {
            String temp = buffer.readLine();
            Stack<Character> stack = new Stack<>();
            checkGoodAndBad(stack, temp);
        }
    }

    private static void checkGoodAndBad(Stack<Character> stack, String temp) {

        for (int i=0; i<temp.length(); ++i) {
            if (stack.isEmpty())
                stack.push(temp.charAt(i));
            else if (stack.peek() == temp.charAt(i))
                stack.pop();
            else
                stack.push(temp.charAt(i));
        }

        sum = stack.isEmpty() ? sum + 1 : sum;
    }

    private static void printGood() {
        System.out.println(sum);
    }

}
