package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 좋은단어1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        int countGoodWord = 0;

        for (int i = 0; i < givenNumber; ++i) {
            String word = buffer.readLine();
            Stack<Character> wordStack = new Stack<>();

            for (int j = 0; j < word.length(); ++j) {
                if (wordStack.isEmpty()) {
                    wordStack.push(word.charAt(j));
                } else if (wordStack.peek() == word.charAt(j)) {
                    wordStack.pop();
                } else
                    wordStack.push(word.charAt(j));
            }
            
            countGoodWord = wordStack.isEmpty() ? countGoodWord + 1 : countGoodWord;
        }

        System.out.println(countGoodWord);
    }

}
