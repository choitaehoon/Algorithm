package study.기초;

import java.io.*;
import java.util.Stack;

@SuppressWarnings("Duplicates")
public class 스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int givenNumber = Integer.parseInt(buffer.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<givenNumber; ++i) {
            String[] store = buffer.readLine().split(" ");
            String motion = store[0];

            if (motion.equals("push"))
                stack.push(Integer.parseInt(store[1]));

            if (motion.equals("pop")) {
                if (!stack.isEmpty()) {
                    writer.write(stack.pop()+"\n");
                    continue;
                }

                writer.write(-1+"\n");
            }

            if (motion.equals("size"))
                writer.write(stack.size()+"\n");

            if (motion.equals("empty"))
                writer.write(stack.isEmpty() ? "1"+"\n" : "0" + "\n");

            if (motion.equals("top")) {
                if (!stack.isEmpty()) {
                    writer.write(stack.peek()+"\n");
                    continue;
                }

                writer.write(-1+"\n");
            }

        }

        writer.close();
    }
}
