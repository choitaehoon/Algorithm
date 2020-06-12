package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 스킬트리1 {

    public static void main(String[] args) {
        System.out.println(solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    private static int solution(String skill, String[] skill_trees) {
        int count = 0;
        int len = skill_trees.length;
        Map<Character, Integer> skillMap = new HashMap<>();

        for (int i = 0; i < skill.length(); ++i)
            skillMap.put(skill.charAt(i), i);

        for (int i = 0; i < len; ++i) {
            int countIndex = 0;
            for (int j = 0; j < skill_trees[i].length(); ++j) {
                if (skillMap.containsKey(skill_trees[i].charAt(j)) && skillMap.get(skill_trees[i].charAt(j)) > countIndex)
                    break;

                if (skill_trees[i].charAt(j) == skill.charAt(countIndex))
                    ++countIndex;
                if (countIndex == skill.length() || j == skill_trees[i].length() - 1) {
                    ++count;
                    break;
                }

            }
        }

        return count;
    }

}
