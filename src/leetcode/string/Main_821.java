package leetcode.string;

import java.util.*;

public class Main_821 {

    public int[] shortestToChar(String s, char c) {
        Map<Integer, Boolean> map = new HashMap<>();
        char[] sArray = s.toCharArray();

        for (int i = 0; i < sArray.length; ++i) {
            if (sArray[i] == c)
                map.put(i, true);
        }

        int[] result = new int[sArray.length];
        for (int i = 0; i < sArray.length; ++i) {
            if (map.containsKey(i)) {
                continue;
            }

            result[i] = min(map, i);
        }

        return result;
    }

    public int min(Map<Integer, Boolean> map, int nowIndex) {
        int compare = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Boolean> maps : map.entrySet()) {
            int key = maps.getKey();

            compare = Math.min(Math.abs(nowIndex - key), compare);
        }

        return compare;
    }

}
