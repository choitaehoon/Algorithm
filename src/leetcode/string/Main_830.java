package leetcode.string;

import java.util.*;

public class Main_830 {

    public List<List<Integer>> largeGroupPositions(String s) {
        if (s.length() < 3) {
            return new ArrayList<>();
        }

        int start = 0;
        int end = 0;
        int count = 1;
        char[] store = s.toCharArray();
        List<List<Integer>> result = new ArrayList<>();

        while (end < s.length()) {
            if (start == end) {
                end++;
            } else if (store[start] == store[end]) {
                end++;
                count++;
            } else if (store[start] != store[end]) {
                if (count >= 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(start); temp.add(end - 1);
                    result.add(temp);
                }

                start = end;
                count = 1;
            }
        }

        if (count >= 3) {
            List<Integer> temp = new ArrayList<>();
            temp.add(start); temp.add(end - 1);
            result.add(temp);
        }

        return result;
    }
}
