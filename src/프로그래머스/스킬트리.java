package 프로그래머스;

import java.util.Stack;

public class 스킬트리 {
    public static void main(String[] args) {
        System.out.println(solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        int sum = 0;

        boolean[] alphabet = new boolean[26];
        for (int j=0; j<skill.length(); ++j)
            alphabet[skill.charAt(j) - 'A'] = true;

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<skill_trees.length; ++i) {

            for (int j=skill.length()-1; j>=0; --j)
                stack.push(skill.charAt(j));

            boolean check = true;

            String store = skill_trees[i];
            for (int j=0; j<store.length(); ++j) {
                if (alphabet[store.charAt(j) - 'A'] && stack.peek() != store.charAt(j)) {
                    check = false;
                    break;
                }
                if (!alphabet[store.charAt(j) - 'A'])
                    continue;

                stack.pop();
            }

            if (check)
                ++sum;
        }

        return sum;
    }

}
