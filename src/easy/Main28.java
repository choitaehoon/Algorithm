package easy;

public class Main28 {

    public static void main(String[] args) {
        System.out.println(strStr2(
                "hello", "ll"
        ));

        System.out.println(strStr2(
                "aaaaa", "bba"
        ));
        System.out.println(strStr2(
                "a", ""
        ));
    }

    public static int strStr(String haystack, String needle) {
        if ((haystack.isEmpty() && needle.isEmpty()) || (!haystack.isEmpty() && needle.isEmpty()))
            return 0;
        else if (haystack.isEmpty() && !needle.isEmpty())
            return -1;

        int haystackLen = haystack.length();
        for (int i = 0; i < haystackLen; ++i) {
            int minLen = Math.min(i + needle.length(), haystackLen);
            if (haystack.substring(i, minLen).equals(needle))
                return i;
        }

        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

}
