package 알고리즘기초.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 접미사배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String line = buffer.readLine();
        String[] array = new String[line.length()];

        for (int i=0; i<array.length; ++i)
            array[i] = line.substring(i,array.length);

        Arrays.parallelSort(array);

        for (int i=0; i<array.length; ++i)
            System.out.println(array[i]);
    }
}
