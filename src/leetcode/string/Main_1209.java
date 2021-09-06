package leetcode.string;

public class Main_1209 {

    public String removeDuplicates(String s, int k) {
        char[] compare = new char[s.length()];
        char[] array = s.toCharArray();
        int index = 0;

        for (int i = 0; i < s.length(); ++i) {
            compare[index++] = array[i];

            if (index >= k && check(compare, index - k, k)) {
                index -= k;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < index; ++i)
            builder.append(compare[i]);

        return builder.toString();
    }

    public boolean check(char[] compare, int start, int k) {

        char word = compare[start];
        for (int i = start + 1; i < start + k; ++i) {
            if (word != compare[i])
                return false;
        }

        return true;
    }
}
