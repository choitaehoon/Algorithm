package medium;

import java.util.ArrayList;
import java.util.List;

public class Main39 {

    public static void main(String[] args) {
        System.out.println(combinationSum(
                new int[]{2}, 2
        ));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        recursiveCandidates(0, 0, "",candidates, target, result);
        return result;
    }

    private static void recursiveCandidates(int index, int sum, String word, int[] candidates, int target,  List<List<Integer>> result) {
        if (sum == target) {
            word = word.trim();
            String[] temp = word.split(" ");
            List<Integer> resultStore = new ArrayList<>();
            for (String value : temp)
                resultStore.add(Integer.parseInt(value));
            result.add(resultStore);
            return;
        }

        if (index >= candidates.length || sum > target) return;

        recursiveCandidates(index, sum + candidates[index], word+" "+candidates[index], candidates , target, result);
        recursiveCandidates(index + 1, sum, word, candidates , target, result);
    }

}