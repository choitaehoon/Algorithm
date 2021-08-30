package leetcode.greedy;

public class Main_1323 {

    public int maximum69Number (int num) {
        String number = String.valueOf(num);
        String result = "";
        int index = 0;

        for (int i = 0; i < number.length(); ++i, ++index) {
            if (number.charAt(i) == '6') {
                result += "9";
                break;
            } else {
                result += "9";
            }
        }

        if (index != number.length()) {
            result += number.substring(index + 1);
        }

        return Integer.parseInt(result);
    }

}
