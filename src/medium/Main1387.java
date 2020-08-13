package medium;

import java.util.*;

public class Main1387 {

    public static void main(String[] args) {
        System.out.println(getKth(
                12, 15, 2
        ));
    }

    public static int getKth(int lo, int hi, int k) {
        int[] memoizationArray = new int[1_000_000];
        Map<Integer, Integer> memoizationStore = new HashMap<>();
        Arrays.fill(memoizationArray, Integer.MAX_VALUE);

        for (int i = lo; i <= hi; ++i) {
            memoizationStore.put(i, recursiveGetKth(i, memoizationArray));
        }

        List<Map.Entry<Integer, Integer>> result = new ArrayList<>(memoizationStore.entrySet());
        result.sort((a1, a2) -> {
            int r = a1.getValue() - a2.getValue();
            if (r != 0) return r;

            return a1.getKey() - a2.getKey();
        });

        return result.get(k - 1).getKey();
    }

    private static int recursiveGetKth(int num, int[] memoizationArray) {
        if (num == 1 || num < 1 || num > 1_000_000) return 0;
        if (memoizationArray[num] != Integer.MAX_VALUE) return memoizationArray[num];

        if (num % 2 == 0) {
            return memoizationArray[num] = Math.min(recursiveGetKth(num / 2, memoizationArray) + 1, memoizationArray[num]);
        } else {
            return memoizationArray[num] = Math.min(recursiveGetKth(num * 3 + 1, memoizationArray) + 1, memoizationArray[num]);
        }

    }

}
