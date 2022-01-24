package leetcode.greedy;

public class Main_409 {

    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char value: s.toCharArray())
            count[value]++;

        int ans = 0;
        for (int value: count) {
            ans += value / 2 * 2;
            if (ans % 2 == 0 && value % 2 == 1)
                ans++;
        }

        return ans;
    }

}
