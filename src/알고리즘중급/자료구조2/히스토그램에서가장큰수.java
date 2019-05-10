package 알고리즘중급.자료구조2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 히스토그램에서가장큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber;

        do {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            givenNumber = Integer.parseInt(token.nextToken());
            int[] array = new int[givenNumber];
            Stack<Integer> stack = new Stack<>();

            for (int i=0; i<givenNumber; ++i)
                array[i] = Integer.parseInt(token.nextToken());

            long result = 0;
            for (int i=0; i<givenNumber; ++i) {
                while (!stack.isEmpty() && array[stack.peek()] > array[i]) {
                    long height = array[stack.pop()];
                    long width = i;
                    if (!stack.isEmpty()) width = i - stack.peek() -1 ;
                    if (result < height * width)
                        result = height*width;
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                long height = array[stack.pop()];
                long width = givenNumber;

                if (!stack.isEmpty()) width = givenNumber - stack.peek() - 1;
                if (result < height * width)
                    result = height*width;
            }

            if (givenNumber != 0)
                System.out.println(result);
        }while (givenNumber != 0);

    }
}
