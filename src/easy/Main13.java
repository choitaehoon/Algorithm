package easy;

import java.util.HashMap;
import java.util.Map;

public class Main13 {

    public static void main(String[] args) {
//        System.out.println(romanToInt(
//                "III"
//        ));
//        System.out.println(romanToInt(
//                "IV"
//        ));
//        System.out.println(romanToInt(
//                "IX"
//        ));
//        System.out.println(romanToInt(
//                "LVIII"
//        ));
        System.out.println(romanToInt(
                "MC"
        ));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> roma = new HashMap<>();
        roma.put('I', 1); roma.put('V', 5); roma.put('X', 10);
        roma.put('L', 50); roma.put('C', 100); roma.put('D', 500);
        roma.put('M', 1000);

        if (s.length() < 2) {
            return roma.get(s.charAt(0));
        }

        int sum = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i + 1 < s.length() && roma.get(s.charAt(i)) < roma.get(s.charAt(i + 1))) {
                sum -= roma.get(s.charAt(i));
            } else
                sum += roma.get(s.charAt(i));
        }

        return sum;
    }
}
