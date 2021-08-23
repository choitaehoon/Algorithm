package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문자열반복1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < n; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int k = Integer.parseInt(token.nextToken());
            String word = token.nextToken();

            StringBuilder builder = new StringBuilder();
            char[] array = word.toCharArray();

            for (int m = 0; m < array.length; ++m) {
                char nowWord= array[m];
                for (int q = 0; q < k; ++q) {
                    builder.append(nowWord);
                }
            }

            System.out.println(builder.toString());
        }
    }

}
