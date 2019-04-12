package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        Words[] words = new Words[givenNumber];
        Map<String,Integer> map = new HashMap<>();

        for (int i=0; i<givenNumber; ++i) {
            String word = buffer.readLine();
            words[i] = new Words(word.length(), word);
        }

        Arrays.sort(words);

        for (int i=0; i<words.length; ++i) {
            if (map.get(words[i].words) == null) {
                map.put(words[i].words, 1);
                System.out.println(words[i].words);
            }
        }

    }
}

class Words implements Comparable<Words> {
    int length;
    String words;

    public Words(int length, String words) {
        this.length = length;
        this.words = words;
    }

    @Override
    public int compareTo(Words o) {
        int r = this.length - o.length;
        if (r!=0) return r;
        return this.words.compareTo(o.words);
    }
}
