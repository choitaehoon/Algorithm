package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 단어수학다시풀기 {

    static int[] alphabetArray = new int[26];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            char[] alphabet = buffer.readLine().toCharArray();
            int alphabetLength = alphabet.length-1 ;
            for (Character character : alphabet)
                alphabetArray[character - 'A'] += (int)(Math.pow(10, alphabetLength-- ));
        }

        Arrays.sort(alphabetArray);

        for (int i=alphabetArray.length-1; i>=0 ; --i) {
            if (alphabetArray[i] == 0)
                break;
            list.add(alphabetArray[i]);
        }

        Collections.sort(list);
        Collections.reverse(list);


        int sum = 0;
        int multiply = 9;
        for (int i=0; i<list.size(); ++i)
            sum += (list.get(i) * multiply--);

        System.out.println(sum);
    }
}
