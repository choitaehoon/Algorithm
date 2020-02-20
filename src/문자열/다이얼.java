package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 다이얼 {

    static Map<Character, Integer> map = new HashMap<>();
    static String word;

    public static void main(String[] args) throws IOException {
        inputMapAndWord();
        printGo();
    }

    private static void inputMapAndWord() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        word = buffer.readLine();
        int store = 'A';

        for (int i=2; i<=9; ++i) {

            if (i == 7 || i == 9) {
                for (int z = 0; z < 4; ++z) {
                    map.put((char)(store), i);
                    store++;
                }

            } else {
                for (int z = 0; z<3; ++z) {
                    map.put((char)(store), i);
                    store++;
                }
            }

        }

    }

    private static void printGo() {
        int sum = 0;

        for (int i=0; i<word.length(); ++i) {
            sum += map.get(word.charAt(i)) + 1;
        }
ㄷ
        System.out.println(sum);
    }

}
