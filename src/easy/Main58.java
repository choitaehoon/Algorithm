package easy;

public class Main58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a"));
    }

    public static int lengthOfLastWord(String s) {
        int emptyCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ')
                ++emptyCount;
        }

        if (s.length() == emptyCount)
            return 0;

        String[] sStore = s.split(" ");

        return sStore[sStore.length - 1].length();
    }

}
