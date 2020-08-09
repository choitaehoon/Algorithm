package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main20 {

    static Map<Character, Character> bracket = new HashMap<>();

    static {
        bracket.put(')', '(');
        bracket.put(']', '[');
        bracket.put('}', '{');
    }

    public static void main(String[] args) {
        System.out.println(isValid(
                "(])"
        ));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (char sValue : s.toCharArray()) {
            if (bracket.containsKey(sValue)) {
                char nowWord = stack.isEmpty() ? '*' : stack.pop();

                if (nowWord != bracket.get(sValue))
                    return false;

            } else {
                stack.push(sValue);
            }
        }

        return stack.isEmpty();
    }

}


