package leetcode;

import java.util.Arrays;

public class Main_1624 {

    public static int maxLengthBetweenEqualCharacters(String s) {
        int sLength = s.length();
        int size = -1;

        for (int i = 0; i < sLength; ++i) {
            char startWord = s.charAt(i);

            for (int k = i + 1; k < sLength; ++k) {
                char circleWord = s.charAt(k);

                if (startWord == circleWord) {
                    size = Math.max(size, k - i - 1);
                }
            }
        }

        return size;
    }

    public static int maxLengthBetweenEqualCharacters2(String s) {
        int[] res = new int[26];
        Arrays.fill(res, -1);
        int max = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (res[ch - 'a'] == -1) {
                res[ch - 'a'] = i;
            } else {
                max = Math.max(max, i - res[ch - 'a'] - 1);
            }
        }

        return max;
    }

}
