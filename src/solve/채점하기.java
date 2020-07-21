package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 채점하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String word = buffer.readLine();

        int correct = 0;
        int sum = 0;

        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == 'x') {
                correct = 0;
            } else
                sum += ++correct;
        }

        System.out.println(sum);

    }

}
