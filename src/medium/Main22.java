package medium;

import java.util.ArrayList;
import java.util.List;

public class Main22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recursiveGenerateParenthesis(0, 0, n, "", result);
        return result;
    }

    private static void recursiveGenerateParenthesis(int open, int close, int n, String word, List<String> result) {
        if (word.length() == n * 2) {
            result.add(word);
            return;
        }

        if (open < n)
            recursiveGenerateParenthesis(open + 1, close, n, word+"(", result);
        if (close < open)
            recursiveGenerateParenthesis(open, close + 1, n, word+")", result);
    }

}