package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//메모리 조심
public class 수이어쓰기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        StringBuilder builder = new StringBuilder();
        int sum = 0;

        for (int i=1; i<=givenNumber; ++i) {
            builder.append(i);
            if (i%10000 == 0 || givenNumber == i) {
                sum += builder.length();
                builder.setLength(0);
            }
        }

        System.out.println(sum);
    }
}
