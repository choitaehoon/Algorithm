package leetcode.string;

import java.util.*;

public class Main_451 {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char now : s.toCharArray()) {
            map.put(now, map.getOrDefault(now, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> maps : list) {
            circle(maps.getKey(), builder, maps.getValue());
        }

        return builder.toString();
    }

    public StringBuilder circle(char word, StringBuilder builder, int len) {
        for (int i = 0; i < len; ++i)
            builder.append(word);

        return builder;
    }

}
