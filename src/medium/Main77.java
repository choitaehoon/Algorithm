package medium;

import java.util.ArrayList;
import java.util.List;

public class Main77 {

    static int limit;
    static int count;

    public static void main(String[] args) {
        System.out.println(combine(1, 100));
    }

    public static List<List<Integer>> combine(int n, int k) {
        limit = n;
        count = k;
        List<List<Integer>> result = new ArrayList<>();
        recursiveCombine(1, 0, "", result);

        return result;
    }

    private static void recursiveCombine(int num, int nowCount, String word, List<List<Integer>> result) {
        if (count == nowCount) {
            String[] temp = word.trim().split(" ");
            List<Integer> store = new ArrayList<>();
            for (String value : temp) {
                store.add(Integer.parseInt(value));
            }
            result.add(store);
            return;
        }

        if (num > limit) return;

        recursiveCombine(num + 1, nowCount + 1, word+" "+num, result);
        recursiveCombine(num + 1, nowCount, word, result);
    }

}
