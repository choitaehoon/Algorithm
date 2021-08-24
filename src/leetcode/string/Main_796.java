package leetcode.string;

public class Main_796 {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); ++i) {
            StringBuilder builder = new StringBuilder();

            String post = s.substring(i);
            String pre = s.substring(0, i);
            String compare = post + pre;

            if (compare.equals(goal))
                return true;

        }

        return false;
    }

    public boolean rotateString1(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        s += s;
        return s.contains(goal);
    }
}
