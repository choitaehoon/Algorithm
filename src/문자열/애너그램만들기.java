package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 애너그램만들기 {

    static int[][] array = new int[2][26];
    static int sum;

    public static void main(String[] args) throws IOException {
        inputArray();
        actionGram();
        printSum();
    }

    private static void inputArray() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<2; ++i) {
            String temp = buffer.readLine();
            inputArray(i, temp);
        }
    }

    private static void inputArray(int index, String temp) {
        for (int i=0; i<temp.length(); ++i)
            array[index][temp.charAt(i) - 'a']++;
    }

    private static void actionGram() {
        for (int i=0; i<26; ++i) {
            if (array[0][i] != array[1][i]) {
                sum += Math.abs(array[0][i] - array[1][i]);
            }
        }
    }

    private static void printSum() {
        System.out.println(sum);
    }
    
}
