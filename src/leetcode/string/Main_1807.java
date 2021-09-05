package leetcode.string;

import java.util.*;

public class Main_1807 {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = mapStore(knowledge);
        StringBuilder builder = new StringBuilder();
        String compare = "";
        boolean open = false;

        for (char word : s.toCharArray()) {
            if (word == '(') {
                open = true;
            } else if (open && word == ')') {
                builder.append(map.getOrDefault(compare, "?"));

                compare = "";
                open = false;
            } else if (open) {
                compare += String.valueOf(word);
            } else {
                builder.append(word);
            }
        }

        return builder.toString();
    }

    public Map<String, String> mapStore(List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        int index = 0;

        for (List<String> one : knowledge) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < one.size(); ++i) {
                list.add(one.get(i));
            }

            map.put(list.get(0), list.get(1));
        }

        return map;
    }
}
