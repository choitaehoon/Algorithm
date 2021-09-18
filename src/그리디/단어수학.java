package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 단어수학 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int[] array = new int[26];

        for (int i = 0; i < n; ++i) {
            String word = buffer.readLine();
            int length = word.length() - 1;
            for (int k = 0; k < word.length(); ++k) {
                char now = word.charAt(k);
                array[now - 'A'] += (int)(Math.pow(10, length--));
            }
        }

        Arrays.sort(array);
        int num = 9;
        int result = 0;
        for (int i = 25; i >= 0; --i) {
            if (array[i] == 0)
                continue;

            result += num * array[i];
            num --;
        }

        System.out.println(result);
    }

}
