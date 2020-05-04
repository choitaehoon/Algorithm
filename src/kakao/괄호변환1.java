package kakao;

import java.util.Stack;

public class 괄호변환1 {

    static int index;

    public static void main(String[] args) {

    }

    public String solution(String p) {
        if (p.isEmpty())
            return "";

        boolean isCorrect = correct(p);
        String u = p.substring(0, index);
        String v = p.substring(index);

        if (isCorrect) {
            return u + solution(v);
        }

        String temp = "(" + solution(v) + ")";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < u.length() - 1; ++i) {
            if (u.charAt(i) == '(')
                builder.append(")");
            else
                builder.append("(");
        }

        return temp + builder.toString();
    }

    private boolean correct(String p) {
        boolean isCheck = true;
        int left = 0;
        int right = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<p.length(); ++i) {
            if (p.charAt(i) == '(') {
                ++left;
                stack.push(p.charAt(i));
            } else {
                ++right;

                if (stack.isEmpty()) {
                    isCheck = false;
                } else {
                    stack.pop();
                }
            }

            if (left == right) {
                index = i + 1;
                return isCheck;
            }
        }

        return true;
    }
}
