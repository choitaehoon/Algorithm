package leetcode.string;

public class Main_392 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0 && t.length() == 0)
            return true;

        if (s.length() == 0 && t.length() != 0) {
            return true;
        }

        if (s.length() != 0 && t.length() == 0)
            return false;

        char[] tC = t.toCharArray();
        char[] sC = s.toCharArray();
        int sIndex = 0;

        for (int i = 0; i < tC.length; ++i) {
            if (sIndex == s.length())
                return true;

            if (tC[i] == sC[sIndex]) {
                sIndex++;
            }
        }

        return sIndex == s.length();
    }
}
