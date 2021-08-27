package leetcode.string;

import java.util.*;

public class Main_205 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic(
                "paper",
                "title"
        ));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s1 = new HashMap<>();
        Map<Character, Character> t1 = new HashMap<>();

        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char nowT = t.charAt(i);
            char nowS = s.charAt(i);

            if (!s1.containsKey(nowS) && !t1.containsKey(nowT)) {
                s1.put(nowS, nowT);
                t1.put(nowT, nowS);
            } else if (s1.containsKey(nowS) && s1.get(nowS) != nowT) {
                return false;
            } else if (t1.containsKey(nowT) && t1.get(nowT) != nowS) {
                return false;
            }
        }

        return true;
    }
}
