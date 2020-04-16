package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 단어수학다시풀기1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int[] array = new int[26];
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<n; ++i) {
            char[] temp = buffer.readLine().toCharArray();
            int lengthAlphabet = temp.length - 1;

            for (char value : temp) {
                array[value - 'A'] += Math.pow(10, lengthAlphabet--);
            }
        }

        for (int i=0; i<26; ++i) {
            if (array[i] == 0)
                continue;
            list.add(array[i]);
        }

        Collections.sort(list);
        Collections.reverse(list);

        int result = 0;
        int minusNumber = 9;
        for (Integer integer : list) {
            result += integer * minusNumber--;
        }

        System.out.println(result);
    }


}
