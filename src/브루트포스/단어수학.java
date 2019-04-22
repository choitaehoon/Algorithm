package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어수학 {

    static int[] array;
    static List<Integer> list = new ArrayList<>();
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        array = new int[26];

        for (int i = 0; i < givenNumber; ++i) {
            String temp = buffer.readLine();
            for (int j=0; j<temp.length(); ++j)
                    array[temp.charAt(j) - 'A'] += (int)(Math.pow(10 , (temp.length()-1) - j) );
        }

        for (int i=0; i<array.length; ++i) {
            if (array[i] != 0)
                list.add(array[i]);
            else
                break;
        }

        Collections.sort(list);
        Collections.reverse(list);

        int multiply = 9;
        for (int i=0; i<list.size(); ++i)
            max += list.get(i) * multiply--;

        System.out.println(max);
    }
}