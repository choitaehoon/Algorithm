package leetcode;

import java.util.*;

public class Main_1876 {

    public int countGoodSubstrings(String s) {
        int sLen = s.length();
        if (sLen == 1 || sLen == 2) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < sLen; ++i) {
            String nowWord = s.substring(i, i + 3 > sLen ? sLen : i + 3);

            if (nowWord.length() == 3) {
                char[] search = nowWord.toCharArray();
                Map<Character, Boolean> map = new HashMap<>();

                for (int k = 0; k < 3; ++k) {

                    if (!map.containsKey(search[k])) {
                        map.put(search[k], true);

                        if (k == 2) {
                            ++count;
                        }
                    } else {
                        break;
                    }
                }

            }
        }

        return count;
    }
}
