package leetcode.string;

public class Main_1869 {

    public boolean checkZeroOnes(String s) {

        int one = count('1', s.toCharArray());
        int zero = count('0', s.toCharArray());

        return zero < one;
    }

    public int count(char compare, char[] sChar) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < sChar.length; ++i) {
            if (compare == sChar[i]) {
                ++count;
            } else {
                max = Math.max(max, count);
                count = 0;
            }

            if (i == sChar.length - 1 && count != 0) {
                max = Math.max(max, count);
            }

        }


        return max;
    }

}
