package study.기초;

import java.io.*;
import java.util.Stack;

public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String keword = buffer.readLine();
        int givenNumber = Integer.parseInt(buffer.readLine());

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        //left에 삽입
        for (int i=0; i<keword.length(); ++i)
            left.push(String.valueOf(keword.charAt(i)));

        for (int i=0; i<givenNumber; ++i) {
            String[] store = buffer.readLine().split(" ");

            if (store[0].equals("L") && !left.isEmpty())
                right.push(left.pop());

            else if (store[0].equals("D") && !right.isEmpty())
                left.push(right.pop());

            else if (store[0].equals("B") && !left.isEmpty())
                left.pop();

            else if (store[0].equals("P"))
                left.push(store[1]);
        }

        while (!left.isEmpty())
            right.push(left.pop());

        while (!right.isEmpty())
            writer.write(right.pop());

        writer.close();
    }
}
