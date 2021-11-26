package 문자열;

public class Main_1768 {

    public static void main(String[] args) {
        System.out.println(
                mergeAlternately("ab", "pqrs")
        );
    }

    public static String mergeAlternately(String word1, String word2) {
        int word1Len = word1.length();
        int word2Len = word2.length();
        int word1Index = 0;
        int word2Index = 0;
        int len = word1Len + word2Len;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < len; ++i) {
            if (word1Index == word1Len && word2Index < word2Len)
                builder.append(word2.charAt(word2Index++));

            else if (word2Index == word2Len && word1Index < word1Len)
                builder.append(word1.charAt(word1Index++));

            else if (word1Index < word1Len && i % 2 == 0)
                builder.append(word1.charAt(word1Index++));

            else
                builder.append(word2.charAt(word2Index++));
        }

        return builder.toString();
    }

}
