package leetcode.string;

import java.util.*;

public class Main_1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;

        for (List<String> circle : items) {
            String type = circle.get(0);
            String color = circle.get(1);
            String name = circle.get(2);

            if (ruleKey.equals("type") && ruleValue.equals(type)) {
                ++count;
            } else if (ruleKey.equals("color") && ruleValue.equals(color)) {
                ++count;
            } else if (ruleKey.equals("name") && ruleValue.equals(name)){
                ++count;
            }

        }


        return count;
    }
}
