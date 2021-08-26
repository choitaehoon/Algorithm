package leetcode.string;

import java.util.*;

public class Main_1544 {

    public static void main(String[] args) {
        System.out.println(makeGood(
                "abBAcC"
        ));
    }

    public static String makeGood(String s) {
        StringBuilder result = new StringBuilder();
        for (char nowWord : s.toCharArray()) {
            int n = result.length();
            if (n > 0 && Math.abs(nowWord - s.charAt(n - 1)) == 32) {
                result.deleteCharAt(n - 1);
            } else {
                result.append(nowWord);
            }
        }

        return result.toString();
    }
}
