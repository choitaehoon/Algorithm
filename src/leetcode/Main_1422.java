package leetcode;

import java.util.Arrays;

public class Main_1422 {

    public static void main(String[] args) {
        System.out.println(
                maxScore("1111")
        );
    }

    public static int maxScore(String s) {
        int sLength = s.length();
        int maxScore = 0;

        int[] zeroArray = new int[sLength];
        int[] oneArray = new int[sLength];

        for (int i = 0; i < sLength; ++i) {
            if (s.charAt(i) == '0') {
                zeroArray[i]++;
            }

            if (i > 0) {
                zeroArray[i] += zeroArray[i - 1];
            }
        }

        for (int i = sLength - 1; i >= 0; --i) {
            if (s.charAt(i) == '1') {
                oneArray[i]++;
            }

            if (i > 0) {
                oneArray[i - 1] += oneArray[i];
            }
        }

        for (int i = 0; i < sLength - 1; ++i) {
            maxScore = Math.max(maxScore, zeroArray[i] + oneArray[i + 1]);
        }

        return maxScore;
    }

    public int maxScore2(String s) {
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            res += s.charAt(i) - '0';
        }
        res += s.charAt(0) == '0' ? 1 : 0;

        int val = res;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                val++;
            }
            else {
                val--;
            }
            res = Math.max(res, val);
        }

        return res;
    }

}
