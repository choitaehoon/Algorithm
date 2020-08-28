package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main78 {


    public static void main(String[] args) {
        System.out.println(subsets(
                new int[]{1, 2, 3}
        ));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> resultStore = new HashSet<>();

        searchNums(0, "", nums, resultStore);
        List<List<Integer>> result = new ArrayList<>(resultStore);
        result.add(new ArrayList<>());
        return result;
    }

    private static void searchNums(int index, String word, int[] nums, Set<List<Integer>> resultStore) {
       if (word.length() >= 1) {
           String[] splitNums = word.trim().split(" ");
           List<Integer> resultStoreList = new ArrayList<>();
           for (String value : splitNums)
               resultStoreList.add(Integer.parseInt(value));
           resultStore.add(resultStoreList);
       }

        if (index >= nums.length)
            return;

        searchNums(index + 1, word + " " +nums[index] , nums, resultStore);
        searchNums(index + 1, word, nums, resultStore);
    }

}
