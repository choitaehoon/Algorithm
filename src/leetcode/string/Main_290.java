package leetcode.string;

import java.util.*;

public class Main_290 {

    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> map = new HashMap<>();
        Map<Character, String> map2 = new HashMap<>();
        char[] sStore = pattern.toCharArray();
        String[] temp = s.split(" ");
        int tempLen = temp.length;

        if (temp.length != sStore.length)
            return false;

        for (int i = 0; i < tempLen; ++i) {
            String nowString = temp[i];
            char nowChar = pattern.charAt(i);

            if (map.containsKey(nowString)) {
                if (map.get(nowString) != nowChar)
                    return false;
            }

            if (map2.containsKey(nowChar)) {
                if (!map2.get(nowChar).equals(nowString))
                    return false;
            }

            if (!map.containsKey(nowString)) {
                map.put(nowString, nowChar);
            }

            if (!map2.containsKey(nowChar)) {
                map2.put(nowChar, nowString);
            }

        }

        return true;
    }

}
