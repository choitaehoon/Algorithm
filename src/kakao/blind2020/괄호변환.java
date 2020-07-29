package kakao.blind2020;

import java.util.Stack;

public class 괄호변환 {

    static int subStringIndex;

    public static void main(String[] args) {

    }

    public static String solution(String p) {
        if (p.isEmpty())
            return "";

        boolean isCorrectWord = correctWord(p);
        String u = p.substring(0, subStringIndex);
        String v = p.substring(subStringIndex);

        if (isCorrectWord)
            return u + solution(v);

        String emptyWord = "(" + solution(v) + ")";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < u.length() - 1; ++i) {
            if (u.charAt(i) == '(')
                builder.append(')');
            else
                builder.append('(');
        }

        return emptyWord + builder.toString();
    }

    private static boolean correctWord(String p) {
        boolean isCheck = true;
        int left = 0;
        int right = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < p.length(); ++i) {
            if (p.charAt(i) == '(') {
                stack.push('(');
                left++;
            } else {
                right++;

                if (stack.isEmpty())
                    isCheck = false;
                else
                    stack.pop();
            }

            if (left == right) {
                subStringIndex = i + 1;
                return isCheck;
            }
        }

        return true;
    }

}
