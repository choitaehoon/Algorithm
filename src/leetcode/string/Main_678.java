package leetcode.string;

public class Main_678 {

    public static void main(String[] args) {
        System.out.println(checkValidString(
                "(*)"
        ));
    }

    public static boolean checkValidString(String s) {
        int lo = 0, hi = 0;

        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }

        return lo == 0;
    }
}
