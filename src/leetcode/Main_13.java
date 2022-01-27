package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Main_13 {

    public int romanToInt(String s) {
        Map<Character, Integer> map = createMap();

        int i = s.length() - 1;
        int num = 0;
        while (i >= 0) {
            char c = s.charAt(i);
            int val = map.get(c);
            if (i < s.length() - 1 && val < map.get(s.charAt(i + 1))) {
                num = num - val;
            } else {
                num = num + val;
            }
            i--;
        }

        return num;
    }

    private Map<Character, Integer> createMap() {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        return map;
    }

}
