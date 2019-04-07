package 해시;

public class 전화번호목록 {

    public static void main(String[] args) {
        String[] phone = {"12","123","1235","567","88"};
        String[] test = {"123","456","789"};
        System.out.println(solution(test));
    }

    public static boolean solution(String[] phone_book) {

        for (int i=1; i<phone_book.length; ++i) {
            if (patternMatch(phone_book[i], phone_book[0]))
                    return false;
        }

        return true;
    }

    @SuppressWarnings("Duplicates")
    public static boolean patternMatch(String pattern, String match) {
        int j=0;
        int[] table = makeTable(match);

        for (int i=0; i<pattern.length(); ++i) {
            while (j > 0 && match.charAt(j) != pattern.charAt(i))
                j = table[j-1];

            if (pattern.charAt(i) == match.charAt(j)) {
                if (j == match.length()-1)
                    return true;
                else
                    ++j;
            }

        }
        return false;
    }

    @SuppressWarnings("Duplicates")
    public static int[] makeTable(String matcher) {
        int j=0;
        int[] table = new int[matcher.length()];

        for (int i=1; i<matcher.length(); ++i) {
            while (j > 0 && matcher.charAt(j) != matcher.charAt(i))
                j = table[j-1];
            if (matcher.charAt(j) == matcher.charAt(i))
                table[i] = ++j;
        }
        return table;
    }

}
