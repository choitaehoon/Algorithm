package leetcode.string;

import java.util.*;

public class Main_1408 {

    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < words.length; ++i) {
            String now = words[i];

            for (int k = 0; k < words.length; ++k) {
                if (i == k)
                    continue;

                if (now.contains(words[k])) {
                    set.add(words[k]);
                }
            }
        }

        Iterator<String> circle = set.iterator();
        List<String> result = new ArrayList<>();
        while(circle.hasNext()) {
            result.add(circle.next());
        }

        return result;
    }
}
