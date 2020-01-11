package week.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어뒤집기9093 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        //출력
        for (int i=0; i<givenNumber; ++i) {
            System.out.println(reverseWord(buffer.readLine()));
        }

    }

    //단어 뒤집는 메소드
    private static String reverseWord(String words) {
        String[] word = words.split(" ");
        StringBuilder builder = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i=0; i<word.length; ++i) {
            builder.append(word[i]).reverse();
            result.append(builder).append(" ");
            builder.setLength(0);
        }

        return result.toString();
    }

}
