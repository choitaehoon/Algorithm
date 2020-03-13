package kakao;

import java.util.Stack;

public class 괄호변환 {

    static int index;

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
    }

    public static String solution(String p) {
        if (p.isEmpty())
            return "";

        boolean isCorrect = checkP(p);
        String u = p.substring(0, index);
        String v = p.substring(index);

        if (isCorrect) {
            return u + solution(v);
        }

        String temp = "(" + solution(v) + ")";
        StringBuilder store = new StringBuilder();
        for (int i=1; i<u.length() - 1; ++i) {
            if (u.charAt(i) == '(')
                store.append(")");
            else
                store.append("(");
        }

        index = 0;
        return temp + store.toString();
    }

    private static boolean checkP(String p) {

        boolean isCheck = true;
        Stack<Character> stack = new Stack<>();
        int left = 0, right = 0;

        for(int i=0; i<p.length(); ++i) {
            if (p.charAt(i) == '(') {
                ++left;
                stack.push(p.charAt(i));
            } else {
                ++right;

                if (stack.isEmpty())
                    isCheck = false;
                else
                    stack.pop();
            }

            if (left == right) {
                index = i + 1;
                return isCheck;
            }
        }

        return true;
    }

}
