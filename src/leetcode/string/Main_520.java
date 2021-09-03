package leetcode.string;

public class Main_520 {

    public boolean detectCapitalUse(String word) {

        char[] now = word.toCharArray();
        if (hasAllUpperCase(now)) {
            return true;
        } else if (hasNoUpperCase(now)) {
            return true;
        } else if (hasFirstUpperCase(now)) {
            return true;
        }

        return false;
    }

    public boolean hasAllUpperCase(char[] now) {

        for (int i = 0; i < now.length; ++i) {
            if (Character.isLowerCase(now[i]))
                return false;
        }

        return true;
    }

    public boolean hasNoUpperCase(char[] now) {
        for (int i = 0; i < now.length; ++i) {
            if (Character.isUpperCase(now[i]))
                return false;
        }

        return true;
    }

    public boolean hasFirstUpperCase(char[] now) {
        boolean a = true;
        boolean b = true;

        for (int i = 0; i < now.length; ++i) {
            if (i == 0 && Character.isLowerCase(now[i])){
                a = false;
            } else if (i != 0 && Character.isUpperCase(now[i]))
                b = false;
        }

        return a && b;
    }

}
