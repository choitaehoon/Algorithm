package leetcode.string;

import java.util.*;

public class Main_784 {

    public static void main(String[] args) {
        System.out.println(letterCasePermutation(
                "a1b2"
        ));
    }

    public static List<String> letterCasePermutation(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null) {
            return permutations;
        }

        permutations.add(str);

        for (int i=0; i<str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                int n = permutations.size();

                for (int j=0; j<n; j++) {
                    char[] chs = permutations.get(j).toCharArray();
                    if (Character.isUpperCase(chs[i])) {
                        chs[i] = Character.toLowerCase(chs[i]);
                    } else {
                        chs[i] = Character.toUpperCase(chs[i]);
                    }

                    permutations.add(String.valueOf(chs));
                }
            }
        }

        return permutations;
    }
}
