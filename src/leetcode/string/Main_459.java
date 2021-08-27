package leetcode.string;

public class Main_459 {

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1)
            return false;

        for (int i = 1; i <= s.length() / 2; ++i) {
            StringBuilder builder = new StringBuilder();
            builder.append(s.substring(i));
            builder.append(s.substring(0, i));

            if (s.equals(builder.toString())) return true;
        }

        return false;
    }

}
