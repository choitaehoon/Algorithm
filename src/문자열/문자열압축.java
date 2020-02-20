package 문자열;

public class 문자열압축 {

    static int min = Integer.MAX_VALUE;
    static StringBuilder builder = new StringBuilder();
    static int len;
    static String temp;

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }

    public static int solution(String s) {
        for (int i = 1; i <= s.length() / 2; ++i) {
            temp = s.substring(0, i);
            actionDivide(i, s);
            System.out.println(builder);
            min = Math.min(min, builder.toString().length());
            builder.setLength(0);
        }

        return min;
    }

    private static void actionDivide(int index, String s) {

        for (int i=index; i<s.length(); ) {
            String compareWord;

            if (i + index > s.length()) {
                compareWord = s.substring(i);
            } else {
                compareWord = s.substring(i, i + index);
            }

            actionEquals(compareWord, i, s);

            i += index;
        }
    }

    private static void actionEquals(String compareWord, int index, String s) {

        if (temp.equals(compareWord)) {
            len++;

            if (index >= s.length())
                builder.append(len).append(temp);

        } else {

            if (len == 1)
                builder.append(temp);
            else if (index < s.length())
                builder.append(len).append(temp);
            else
                builder.append(temp).append(compareWord);

            temp = compareWord;
            len = 1;
        }

    }

}
