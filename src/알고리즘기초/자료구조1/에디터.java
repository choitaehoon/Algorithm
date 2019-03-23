package 알고리즘기초.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String temp = buffer.readLine();
        int number = Integer.parseInt(buffer.readLine());

        //주어진 알파벳 담는 스택
        Stack<Character> preexistence = new Stack<>();

        //옮겨진 스택
        Stack<Character> delocalized = new Stack<>();

        for (int i =0; i<temp.length(); ++i)
            preexistence.push(temp.charAt(i));


        for (int i=0; i<number; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            String store = token.nextToken();

            // L 문자이고 비어있지 않으면
            if (store.equals("L") && !preexistence.isEmpty())
                delocalized.push(preexistence.pop());

            if (store.equals("D") && !delocalized.isEmpty())
                preexistence.push(delocalized.pop());

            if (store.equals("B") && !preexistence.isEmpty())
                preexistence.pop();

            if (store.equals("P"))
                preexistence.push(token.nextToken().charAt(0));
        }

        StringBuilder builder = new StringBuilder();

        while (!preexistence.isEmpty())
            builder.append(preexistence.pop());

        builder.reverse();

        while (!delocalized.isEmpty())
            builder.append(delocalized.pop());

        System.out.println(builder);


    }
}
