package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main17 {

    static Map<Integer, String> phoneNumber = new HashMap<>();

    static {
        phoneNumber.put(2, "abc");
        phoneNumber.put(3, "def");
        phoneNumber.put(4, "ghi");
        phoneNumber.put(5, "jkl");
        phoneNumber.put(6, "mno");
        phoneNumber.put(7, "pqrs");
        phoneNumber.put(8, "tuv");
        phoneNumber.put(9, "wxyz");
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(
                "23"
        ));
    }

    public static List<String> letterCombinations(String digits) {

        return new ArrayList<>();
    }
}
