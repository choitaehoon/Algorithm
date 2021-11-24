package 문자열;

import java.util.Arrays;

public class Main_1935 {

    public static void main(String[] args) {
        System.out.println(
                canBeTypedWords("hello world", "ad")
        );
        System.out.println(
                canBeTypedWords("leet code", "lt")
        );
        System.out.println(
                canBeTypedWords("leet code", "e")
        );
        System.out.println(
                canBeTypedWords("a b c d e", "abcde")
        );
    }

    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] splitWord = text.split(" ");
        int splitLen = splitWord.length;
        boolean[] check = new boolean[splitLen];

        if (isBrokenZeroLen(brokenLetters)) {
            return splitLen;
        }

        int brokenLettersLen = brokenLetters.length();
        int result = splitLen;

        for (int i = 0; i < brokenLettersLen; ++i) {
            String nowBroken = String.valueOf(brokenLetters.charAt(i));

            for (int k = 0; k < splitLen; ++k) {
                if (splitWord[k].contains(nowBroken))
                    check[k] = true;
            }
        }

        for (int i = 0; i < splitLen; ++i) {
            if (check[i])
                --result;
        }

        return result;
    }

    private static boolean isBrokenZeroLen(String brokenLetters) {
        return brokenLetters.length() == 0;
    }


}
