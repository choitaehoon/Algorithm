package 문자열;

import java.util.Stack;

/**
 * 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. -> okay
 * 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
 *    단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. -> okay
 * 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
 *   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. -> okay
 * 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
 *   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. -> okay
 *   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. -> okay
 *   4-3. ')'를 다시 붙입니다. -> okay
 *   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
 *   4-5. 생성된 문자열을 반환합니다.
 */
public class 괄호변환 {

    static int pos;

    public static void main(String[] args) {
        System.out.println(solution("()())()"));
    }

    public static String solution(String p) {
        if (p.isEmpty())
            return "";

        boolean isCorrect = checkCorrect(p);
        String u = p.substring(0, pos);
        String v = p.substring(pos);

        if (isCorrect) {
            return u + solution(v);
        }

        String answer = "(" + solution(v) + ")";
        for (int i=1; i<u.length()-1; ++i) {
            if (u.charAt(i) == '(')
                answer += ')';
            else
                answer += '(';
        }

        return answer;
    }

    //균형 잡힌 문자열 검
    private static boolean checkCorrect(String p) {
        boolean check = true;
        Stack<Character> stack = new Stack<>();
        int left = 0, right = 0;

        for (int i=0; i<p.length(); ++i) {
            if (p.charAt(i) == '(') {
                left++;
                stack.push('(');
            } else {
                right++;
                if (stack.isEmpty())
                    check = false;
                else
                    stack.pop();
            }

            if (left == right) {
                pos = i + 1;
                return check;
            }
        }

        return true;
    }

}
