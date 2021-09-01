package leetcode.string;

public class Main_1957 {

    public String makeFancyString(String s) {
        int count = 1;
        char nowWord = s.charAt(0);
        StringBuilder builder = new StringBuilder();
        builder.append(nowWord);

        for (int i = 1; i < s.length(); ++i) {
            if (nowWord == s.charAt(i)) {
                ++count;

                if (count == 3) {
                    count--;
                    continue;
                }

                builder.append(nowWord);
            } else {
                nowWord = s.charAt(i);
                count = 1;
                builder.append(nowWord);
            }

        }

        return builder.toString();
    }
}
