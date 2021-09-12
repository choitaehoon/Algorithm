package leetcode.greedy;

import java.util.*;

public class Main_455 {

    public static void main(String[] args) {
        System.out.println(findContentChildren(
                new int[]{1,2,3},
                new int[]{1, 1}
        ));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = g.length - 1;
        int k = s.length - 1;
        int count = 0;

        while (i >= 0 && k >= 0) {
            if (s[k] >= g[i]) {
                i--;
                k--;
                ++count;
            } else {
                i--;
            }
        }

        return count;
    }
}
