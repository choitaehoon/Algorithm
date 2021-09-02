package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int k = Integer.parseInt(buffer.readLine());

        char[] word = buffer.readLine().toCharArray();
        int result = 0;
        int pattern = 0;

        for (int i = 1; i < word.length - 1; ++i) {
            if (word[i - 1] == 'I' && word[i] == 'O' && word[i + 1] == 'I') {
                pattern++;

                if (pattern == n) {
                    result++;
                    pattern--;
                }

                ++i;
            } else {
                pattern = 0;
            }
        }

        System.out.println(result);
    }

}
