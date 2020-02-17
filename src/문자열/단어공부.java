package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 단어공부 {

    static Map<Character, Integer> map = new HashMap<>();
    static String givenAlphabet;

    public static void main(String[] args) throws IOException {
        inputAlphabetAndArray();
        maxAlphabet();
    }

    private static void inputAlphabetAndArray() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenAlphabet = buffer.readLine();

        for (int i=0; i<givenAlphabet.length(); ++i) {
            char alphabet = Character.toUpperCase(givenAlphabet.charAt(i));
            map.put(alphabet, map.get(alphabet) == null ? 1 : map.get(alphabet) + 1);
        }
    }

    private static void maxAlphabet() {
        int max = 0;
        char alphabet = ' ';

        for (Map.Entry<Character, Integer> maps : map.entrySet()) {

            if (max < maps.getValue()) {
                max = maps.getValue();
                alphabet = maps.getKey();
            }

            else if (max == maps.getValue()) {
                alphabet = '?';
            }

        }

        System.out.println(alphabet);
    }

}
