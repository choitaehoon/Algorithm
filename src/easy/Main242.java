package easy;

public class Main242 {

    public static void main(String[] args) {

    }

    public static boolean isAnagram(String s, String t) {
        int[] sArray = new int[26];
        int[] tArray = new int[26];

        for (char value : s.toCharArray())
            sArray[value - 'a']++;

        for (char value : t.toCharArray())
            tArray[value - 'a']++;

        for (int i = 0; i < 26; ++i) {
            if (sArray[i] != tArray[i])
                return false;
        }

        return true;
    }

}
