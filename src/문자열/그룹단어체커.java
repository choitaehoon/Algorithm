package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 그룹단어체커 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        int count = 0;

        for (int i = 0; i < givenNumber; ++i) {
            String word = buffer.readLine();
            Map<Character, Boolean> wordMap = new HashMap<>();

            for (int j = 0; j < word.length(); ++j) {
                if (!wordMap.containsKey(word.charAt(j))) {
                    wordMap.put(word.charAt(j), true);
                } else {
                    if (word.charAt(j - 1) != word.charAt(j))
                        break;
                }

                if (j == word.length() - 1) {
                    ++count;
                }
            }
        }

        System.out.println(count);
    }
}
